
import sys
import antlr4

from dist.VLexer import VLexer
from dist.VParser import VParser

from vast_gen_visitor import VastGenVisitor

spec_file = open(sys.argv[1])
spec = spec_file.read()

inputStream = antlr4.InputStream(spec)
lexer = VLexer(inputStream)
tokenStream = antlr4.CommonTokenStream(lexer)
parser = VParser(tokenStream)
tree = parser.spec()

# Visit tree to get VAST
visitor = VastGenVisitor()
visitor.visit(tree)

# Visit VAST and print string