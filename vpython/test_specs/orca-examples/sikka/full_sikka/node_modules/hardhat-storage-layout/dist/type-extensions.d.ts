import "hardhat/types/config";
import "hardhat/types/runtime";
declare module "hardhat/types/config" {
    interface ProjectPathsUserConfig {
        newStorageLayoutPath?: string;
    }
    interface ProjectPathsConfig {
        newStorageLayoutPath: string;
    }
}
declare module "hardhat/types/runtime" {
    interface HardhatRuntimeEnvironment {
        storageLayout: {
            export: () => Promise<void>;
        };
    }
}
//# sourceMappingURL=type-extensions.d.ts.map