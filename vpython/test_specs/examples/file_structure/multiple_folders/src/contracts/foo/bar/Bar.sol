import {IBar} from "../../interfaces/IBar.sol";
import {IBaz} from "../../interfaces/IBaz.sol";

contract Bar is IBar {
    int bar_var;
    IBaz baz;

    function call_bar() external {
        bar_var += 1;
    }
}
