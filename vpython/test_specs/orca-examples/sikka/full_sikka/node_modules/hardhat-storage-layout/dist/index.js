"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.PluginName = void 0;
const task_names_1 = require("hardhat/builtin-tasks/task-names");
const config_1 = require("hardhat/config");
const plugins_1 = require("hardhat/plugins");
const path_1 = __importDefault(require("path"));
const storageLayout_1 = require("./storageLayout");
require("./type-extensions");
exports.PluginName = "hardhat-storage-layout";
config_1.task(task_names_1.TASK_CHECK).setAction(async (args, hre, runSuper) => {
    await hre.storageLayout.export();
    await runSuper(args);
});
config_1.task(task_names_1.TASK_COMPILE).setAction(async function (args, hre, runSuper) {
    for (const compiler of hre.config.solidity.compilers) {
        compiler.settings.outputSelection["*"]["*"].push("storageLayout");
    }
    console.log(hre.config.solidity.compilers);
    await runSuper(args);
});
config_1.extendConfig((config, userConfig) => {
    var _a;
    const storageLayoutUserPath = (_a = userConfig.paths) === null || _a === void 0 ? void 0 : _a.newStorageLayoutPath;
    let newStorageLayoutPath;
    if (storageLayoutUserPath === undefined) {
        newStorageLayoutPath = path_1.default.join(config.paths.root, "./storageLayout");
    }
    else {
        if (path_1.default.isAbsolute(storageLayoutUserPath)) {
            newStorageLayoutPath = storageLayoutUserPath;
        }
        else {
            newStorageLayoutPath = path_1.default.normalize(path_1.default.join(config.paths.root, storageLayoutUserPath));
        }
    }
    config.paths.newStorageLayoutPath = newStorageLayoutPath;
});
config_1.extendEnvironment(hre => {
    hre.storageLayout = plugins_1.lazyObject(() => new storageLayout_1.StorageLayout(hre));
});
module.exports = {};
//# sourceMappingURL=index.js.map