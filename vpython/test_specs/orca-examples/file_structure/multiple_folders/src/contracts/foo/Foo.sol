import {IFoo} from "../interfaces/IFoo.sol";
import {Bar} from "./bar/Bar.sol";

contract Foo is IFoo {
    int foo_var;
    Bar bar;

    function call_foo() external {
        foo_var += 1;
    }
}
