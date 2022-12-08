import {IBaz} from "../interfaces/IBaz.sol";

contract Baz is IBaz {
    int baz_var;

    function call_baz() external {
        baz_var += 1;
    }
}
