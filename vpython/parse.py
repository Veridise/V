
import sys
import antlr4

from dist.VLexer import VLexer
from dist.VParser import VParser

from vast.vast_gen_visitor import VastGenVisitor
from visitors.tostring_visitor import ToStringVisitor

from antlr4.tree.Trees import Trees

spec_file = open(sys.argv[1])
spec = spec_file.read()

inputStream = antlr4.InputStream(spec)
lexer = VLexer(inputStream)
tokenStream = antlr4.CommonTokenStream(lexer)
parser = VParser(tokenStream)
print("V-Python: Parsing the input to get parse tree")
tree = parser.spec()

# Print parse tree if needed.
# print(Trees.toStringTree(tree, None, parser))

# Visit tree to get VAST
print("V-Python: Converting to VAST using VASTGenVisitor")
visitor = VastGenVisitor()
vast = visitor.visit(tree)

# Visit VAST and print string
# print("V-Python: Converting VAST to String using ToStringVisitor")
# stringvisitor = ToStringVisitor()
# vast_string = stringvisitor.visit(vast)
# print(vast_string)