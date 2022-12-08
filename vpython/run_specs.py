import subprocess
import sys
from pathlib import Path
import os

def run_specs(test_suite):
    test_suite = Path(test_suite)

    if not test_suite.exists():
        print(f'Directory does not exist: {str(test_suite)}.')
        sys.exit(1)

    if not test_suite.is_dir():
        print(f'Test suite should be a directory!')
        sys.exit(1)
    
    # specs_count = 0
    for root, dirs, files in os.walk(test_suite):
        for file in files:
            if file.endswith(".spec"):
                print(os.path.join(root, file))
                spec_path = os.path.join(root, file)
                cmd = ["python3", "parse.py ", spec_path]
                # subprocess.run(cmd)
                # Run python version
                os.system("python3 parse.py " + spec_path)
                # Run cpp version
                # os.system("./../build/parse " + spec_path)

                # specs_count += 1
    # print(specs_count)

if __name__=="__main__":
    run_specs("/Users/stanly/Project/Veridise/V/vpython")
    # compile_test_suite("src/test/oracle")
    # compile_test_suite("src/test/solidity/fuzzer")
    # compile_test_suite("src/test/solidity/features")
