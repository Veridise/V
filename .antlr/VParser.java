// Generated from /Users/stanly/Project/Veridise/V/V.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class VParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LPAREN=1, RPAREN=2, LBRACK=3, RBRACK=4, COMMA=5, SENT=6, FSUM=7, WILDCARD=8, 
		DOT=9, SEQ=10, ASSN=11, LET=12, FOREACH=13, IN=14, IMPORT=15, VARS_LABEL=16, 
		PRECOND_LABEL=17, POSTCOND_LABEL=18, INIT_LABEL=19, SPEC_LABEL=20, SYNTH_LABEL=21, 
		LTLFAIR_LABEL=22, LTLPROP_LABEL=23, INV_LABEL=24, ATOM_PRE_LOC=25, ATOM_POST_LOC=26, 
		CONTRACT_INV=27, PRE_SEP=28, IMP=29, T_BIN=30, T_UN=31, PATH=32, IDENTIFIER=33, 
		A1_BIN=34, A2_BIN=35, A_UN=36, C_BIN=37, L_BIN=38, L_UN=39, NUM=40, NEG_NUM=41, 
		NEWLINE=42, WHITESPACE=43, LINE_COMMENT=44;
	public static final int
		RULE_spec = 0, RULE_behavioralSpec = 1, RULE_testSpec = 2, RULE_tempSpec = 3, 
		RULE_invariantSpec = 4, RULE_synthSpec = 5, RULE_imports = 6, RULE_varsSection = 7, 
		RULE_precondSection = 8, RULE_postcondSection = 9, RULE_initSection = 10, 
		RULE_specSection = 11, RULE_synthSection = 12, RULE_ltlFairnessSection = 13, 
		RULE_ltlPropertySection = 14, RULE_invariantSection = 15, RULE_seqAtom = 16, 
		RULE_declList = 17, RULE_typ = 18, RULE_smartltlAtom = 19, RULE_invAtom = 20, 
		RULE_atom = 21, RULE_atomFn = 22, RULE_atomFnName = 23, RULE_params = 24, 
		RULE_constraint = 25, RULE_boolExpr = 26, RULE_arithExpr = 27, RULE_fnCall = 28, 
		RULE_fnName = 29, RULE_argList = 30, RULE_ident = 31, RULE_varOrNum = 32, 
		RULE_num = 33, RULE_varAccess = 34;
	private static String[] makeRuleNames() {
		return new String[] {
			"spec", "behavioralSpec", "testSpec", "tempSpec", "invariantSpec", "synthSpec", 
			"imports", "varsSection", "precondSection", "postcondSection", "initSection", 
			"specSection", "synthSection", "ltlFairnessSection", "ltlPropertySection", 
			"invariantSection", "seqAtom", "declList", "typ", "smartltlAtom", "invAtom", 
			"atom", "atomFn", "atomFnName", "params", "constraint", "boolExpr", "arithExpr", 
			"fnCall", "fnName", "argList", "ident", "varOrNum", "num", "varAccess"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'['", "']'", "','", "'sent'", "'fsum'", "'*'", "'.'", 
			"';'", "':='", "'let'", "'foreach'", "':'", "'import:'", null, null, 
			null, null, null, null, "'LTLFairness:'", "'LTLProperty:'", null, null, 
			null, "'Cinv'", "'|=>'", "'==>'", null, null, null, null, null, null, 
			"'-'", null, null, "'!'", null, null, null, "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LPAREN", "RPAREN", "LBRACK", "RBRACK", "COMMA", "SENT", "FSUM", 
			"WILDCARD", "DOT", "SEQ", "ASSN", "LET", "FOREACH", "IN", "IMPORT", "VARS_LABEL", 
			"PRECOND_LABEL", "POSTCOND_LABEL", "INIT_LABEL", "SPEC_LABEL", "SYNTH_LABEL", 
			"LTLFAIR_LABEL", "LTLPROP_LABEL", "INV_LABEL", "ATOM_PRE_LOC", "ATOM_POST_LOC", 
			"CONTRACT_INV", "PRE_SEP", "IMP", "T_BIN", "T_UN", "PATH", "IDENTIFIER", 
			"A1_BIN", "A2_BIN", "A_UN", "C_BIN", "L_BIN", "L_UN", "NUM", "NEG_NUM", 
			"NEWLINE", "WHITESPACE", "LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "V.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public VParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SpecContext extends ParserRuleContext {
		public BehavioralSpecContext behavioralSpec() {
			return getRuleContext(BehavioralSpecContext.class,0);
		}
		public TerminalNode EOF() { return getToken(VParser.EOF, 0); }
		public TestSpecContext testSpec() {
			return getRuleContext(TestSpecContext.class,0);
		}
		public TempSpecContext tempSpec() {
			return getRuleContext(TempSpecContext.class,0);
		}
		public InvariantSpecContext invariantSpec() {
			return getRuleContext(InvariantSpecContext.class,0);
		}
		public SynthSpecContext synthSpec() {
			return getRuleContext(SynthSpecContext.class,0);
		}
		public SpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_spec; }
	}

	public final SpecContext spec() throws RecognitionException {
		SpecContext _localctx = new SpecContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_spec);
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				behavioralSpec();
				setState(71);
				match(EOF);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				testSpec();
				setState(74);
				match(EOF);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				tempSpec();
				setState(77);
				match(EOF);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(79);
				invariantSpec();
				setState(80);
				match(EOF);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(82);
				synthSpec();
				setState(83);
				match(EOF);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BehavioralSpecContext extends ParserRuleContext {
		public ImportsContext imports() {
			return getRuleContext(ImportsContext.class,0);
		}
		public PostcondSectionContext postcondSection() {
			return getRuleContext(PostcondSectionContext.class,0);
		}
		public VarsSectionContext varsSection() {
			return getRuleContext(VarsSectionContext.class,0);
		}
		public PrecondSectionContext precondSection() {
			return getRuleContext(PrecondSectionContext.class,0);
		}
		public BehavioralSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_behavioralSpec; }
	}

	public final BehavioralSpecContext behavioralSpec() throws RecognitionException {
		BehavioralSpecContext _localctx = new BehavioralSpecContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_behavioralSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			imports();
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VARS_LABEL) {
				{
				setState(88);
				varsSection();
				}
			}

			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PRECOND_LABEL) {
				{
				setState(91);
				precondSection();
				}
			}

			setState(94);
			postcondSection();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TestSpecContext extends ParserRuleContext {
		public ImportsContext imports() {
			return getRuleContext(ImportsContext.class,0);
		}
		public SpecSectionContext specSection() {
			return getRuleContext(SpecSectionContext.class,0);
		}
		public VarsSectionContext varsSection() {
			return getRuleContext(VarsSectionContext.class,0);
		}
		public InitSectionContext initSection() {
			return getRuleContext(InitSectionContext.class,0);
		}
		public TestSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_testSpec; }
	}

	public final TestSpecContext testSpec() throws RecognitionException {
		TestSpecContext _localctx = new TestSpecContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_testSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			imports();
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VARS_LABEL) {
				{
				setState(97);
				varsSection();
				}
			}

			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INIT_LABEL) {
				{
				setState(100);
				initSection();
				}
			}

			setState(103);
			specSection();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TempSpecContext extends ParserRuleContext {
		public ImportsContext imports() {
			return getRuleContext(ImportsContext.class,0);
		}
		public LtlPropertySectionContext ltlPropertySection() {
			return getRuleContext(LtlPropertySectionContext.class,0);
		}
		public VarsSectionContext varsSection() {
			return getRuleContext(VarsSectionContext.class,0);
		}
		public LtlFairnessSectionContext ltlFairnessSection() {
			return getRuleContext(LtlFairnessSectionContext.class,0);
		}
		public TempSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tempSpec; }
	}

	public final TempSpecContext tempSpec() throws RecognitionException {
		TempSpecContext _localctx = new TempSpecContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tempSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			imports();
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VARS_LABEL) {
				{
				setState(106);
				varsSection();
				}
			}

			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LTLFAIR_LABEL) {
				{
				setState(109);
				ltlFairnessSection();
				}
			}

			setState(112);
			ltlPropertySection();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InvariantSpecContext extends ParserRuleContext {
		public ImportsContext imports() {
			return getRuleContext(ImportsContext.class,0);
		}
		public InvariantSectionContext invariantSection() {
			return getRuleContext(InvariantSectionContext.class,0);
		}
		public VarsSectionContext varsSection() {
			return getRuleContext(VarsSectionContext.class,0);
		}
		public InvariantSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_invariantSpec; }
	}

	public final InvariantSpecContext invariantSpec() throws RecognitionException {
		InvariantSpecContext _localctx = new InvariantSpecContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_invariantSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			imports();
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VARS_LABEL) {
				{
				setState(115);
				varsSection();
				}
			}

			setState(118);
			invariantSection();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SynthSpecContext extends ParserRuleContext {
		public ImportsContext imports() {
			return getRuleContext(ImportsContext.class,0);
		}
		public SynthSectionContext synthSection() {
			return getRuleContext(SynthSectionContext.class,0);
		}
		public VarsSectionContext varsSection() {
			return getRuleContext(VarsSectionContext.class,0);
		}
		public InitSectionContext initSection() {
			return getRuleContext(InitSectionContext.class,0);
		}
		public SynthSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_synthSpec; }
	}

	public final SynthSpecContext synthSpec() throws RecognitionException {
		SynthSpecContext _localctx = new SynthSpecContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_synthSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			imports();
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VARS_LABEL) {
				{
				setState(121);
				varsSection();
				}
			}

			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INIT_LABEL) {
				{
				setState(124);
				initSection();
				}
			}

			setState(127);
			synthSection();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportsContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(VParser.IMPORT, 0); }
		public TerminalNode PATH() { return getToken(VParser.PATH, 0); }
		public ImportsContext imports() {
			return getRuleContext(ImportsContext.class,0);
		}
		public ImportsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imports; }
	}

	public final ImportsContext imports() throws RecognitionException {
		ImportsContext _localctx = new ImportsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_imports);
		try {
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IMPORT:
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				match(IMPORT);
				setState(130);
				match(PATH);
				setState(131);
				imports();
				}
				break;
			case VARS_LABEL:
			case PRECOND_LABEL:
			case POSTCOND_LABEL:
			case INIT_LABEL:
			case SPEC_LABEL:
			case SYNTH_LABEL:
			case LTLFAIR_LABEL:
			case LTLPROP_LABEL:
			case INV_LABEL:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarsSectionContext extends ParserRuleContext {
		public TerminalNode VARS_LABEL() { return getToken(VParser.VARS_LABEL, 0); }
		public DeclListContext declList() {
			return getRuleContext(DeclListContext.class,0);
		}
		public VarsSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varsSection; }
	}

	public final VarsSectionContext varsSection() throws RecognitionException {
		VarsSectionContext _localctx = new VarsSectionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_varsSection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(VARS_LABEL);
			setState(136);
			declList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrecondSectionContext extends ParserRuleContext {
		public TerminalNode PRECOND_LABEL() { return getToken(VParser.PRECOND_LABEL, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public PrecondSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precondSection; }
	}

	public final PrecondSectionContext precondSection() throws RecognitionException {
		PrecondSectionContext _localctx = new PrecondSectionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_precondSection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(PRECOND_LABEL);
			setState(139);
			atom(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostcondSectionContext extends ParserRuleContext {
		public TerminalNode POSTCOND_LABEL() { return getToken(VParser.POSTCOND_LABEL, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public PostcondSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postcondSection; }
	}

	public final PostcondSectionContext postcondSection() throws RecognitionException {
		PostcondSectionContext _localctx = new PostcondSectionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_postcondSection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(POSTCOND_LABEL);
			setState(142);
			atom(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitSectionContext extends ParserRuleContext {
		public TerminalNode INIT_LABEL() { return getToken(VParser.INIT_LABEL, 0); }
		public SeqAtomContext seqAtom() {
			return getRuleContext(SeqAtomContext.class,0);
		}
		public InitSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initSection; }
	}

	public final InitSectionContext initSection() throws RecognitionException {
		InitSectionContext _localctx = new InitSectionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_initSection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(INIT_LABEL);
			setState(145);
			seqAtom();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SpecSectionContext extends ParserRuleContext {
		public TerminalNode SPEC_LABEL() { return getToken(VParser.SPEC_LABEL, 0); }
		public SeqAtomContext seqAtom() {
			return getRuleContext(SeqAtomContext.class,0);
		}
		public SpecSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specSection; }
	}

	public final SpecSectionContext specSection() throws RecognitionException {
		SpecSectionContext _localctx = new SpecSectionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_specSection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(SPEC_LABEL);
			setState(148);
			seqAtom();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SynthSectionContext extends ParserRuleContext {
		public TerminalNode SYNTH_LABEL() { return getToken(VParser.SYNTH_LABEL, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public SynthSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_synthSection; }
	}

	public final SynthSectionContext synthSection() throws RecognitionException {
		SynthSectionContext _localctx = new SynthSectionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_synthSection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(SYNTH_LABEL);
			setState(151);
			atom(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LtlFairnessSectionContext extends ParserRuleContext {
		public TerminalNode LTLFAIR_LABEL() { return getToken(VParser.LTLFAIR_LABEL, 0); }
		public SmartltlAtomContext smartltlAtom() {
			return getRuleContext(SmartltlAtomContext.class,0);
		}
		public LtlFairnessSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ltlFairnessSection; }
	}

	public final LtlFairnessSectionContext ltlFairnessSection() throws RecognitionException {
		LtlFairnessSectionContext _localctx = new LtlFairnessSectionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ltlFairnessSection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(LTLFAIR_LABEL);
			setState(154);
			smartltlAtom(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LtlPropertySectionContext extends ParserRuleContext {
		public TerminalNode LTLPROP_LABEL() { return getToken(VParser.LTLPROP_LABEL, 0); }
		public SmartltlAtomContext smartltlAtom() {
			return getRuleContext(SmartltlAtomContext.class,0);
		}
		public LtlPropertySectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ltlPropertySection; }
	}

	public final LtlPropertySectionContext ltlPropertySection() throws RecognitionException {
		LtlPropertySectionContext _localctx = new LtlPropertySectionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_ltlPropertySection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(LTLPROP_LABEL);
			setState(157);
			smartltlAtom(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InvariantSectionContext extends ParserRuleContext {
		public TerminalNode INV_LABEL() { return getToken(VParser.INV_LABEL, 0); }
		public InvAtomContext invAtom() {
			return getRuleContext(InvAtomContext.class,0);
		}
		public InvariantSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_invariantSection; }
	}

	public final InvariantSectionContext invariantSection() throws RecognitionException {
		InvariantSectionContext _localctx = new InvariantSectionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_invariantSection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(INV_LABEL);
			setState(160);
			invAtom();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SeqAtomContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TerminalNode SEQ() { return getToken(VParser.SEQ, 0); }
		public SeqAtomContext seqAtom() {
			return getRuleContext(SeqAtomContext.class,0);
		}
		public SeqAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seqAtom; }
	}

	public final SeqAtomContext seqAtom() throws RecognitionException {
		SeqAtomContext _localctx = new SeqAtomContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_seqAtom);
		try {
			setState(167);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				atom(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				atom(0);
				setState(164);
				match(SEQ);
				setState(165);
				seqAtom();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclListContext extends ParserRuleContext {
		public TypContext typ() {
			return getRuleContext(TypContext.class,0);
		}
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(VParser.COMMA, 0); }
		public DeclListContext declList() {
			return getRuleContext(DeclListContext.class,0);
		}
		public DeclListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declList; }
	}

	public final DeclListContext declList() throws RecognitionException {
		DeclListContext _localctx = new DeclListContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_declList);
		try {
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(169);
				typ();
				setState(170);
				ident();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				typ();
				setState(173);
				ident();
				setState(174);
				match(COMMA);
				setState(175);
				declList();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(VParser.IDENTIFIER, 0); }
		public TerminalNode LBRACK() { return getToken(VParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(VParser.RBRACK, 0); }
		public TypContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typ; }
	}

	public final TypContext typ() throws RecognitionException {
		TypContext _localctx = new TypContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_typ);
		try {
			setState(183);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				match(IDENTIFIER);
				setState(181);
				match(LBRACK);
				setState(182);
				match(RBRACK);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SmartltlAtomContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(VParser.LPAREN, 0); }
		public List<SmartltlAtomContext> smartltlAtom() {
			return getRuleContexts(SmartltlAtomContext.class);
		}
		public SmartltlAtomContext smartltlAtom(int i) {
			return getRuleContext(SmartltlAtomContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(VParser.RPAREN, 0); }
		public TerminalNode T_UN() { return getToken(VParser.T_UN, 0); }
		public TerminalNode L_UN() { return getToken(VParser.L_UN, 0); }
		public TerminalNode LBRACK() { return getToken(VParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(VParser.RBRACK, 0); }
		public TerminalNode T_BIN() { return getToken(VParser.T_BIN, 0); }
		public TerminalNode IMP() { return getToken(VParser.IMP, 0); }
		public TerminalNode SEQ() { return getToken(VParser.SEQ, 0); }
		public TerminalNode L_BIN() { return getToken(VParser.L_BIN, 0); }
		public SmartltlAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_smartltlAtom; }
	}

	public final SmartltlAtomContext smartltlAtom() throws RecognitionException {
		return smartltlAtom(0);
	}

	private SmartltlAtomContext smartltlAtom(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SmartltlAtomContext _localctx = new SmartltlAtomContext(_ctx, _parentState);
		SmartltlAtomContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_smartltlAtom, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(186);
				atom(0);
				}
				break;
			case 2:
				{
				setState(187);
				match(LPAREN);
				setState(188);
				smartltlAtom(0);
				setState(189);
				match(RPAREN);
				}
				break;
			case 3:
				{
				setState(191);
				match(T_UN);
				setState(192);
				smartltlAtom(7);
				}
				break;
			case 4:
				{
				setState(193);
				match(L_UN);
				setState(194);
				smartltlAtom(6);
				}
				break;
			case 5:
				{
				setState(195);
				match(LBRACK);
				setState(196);
				match(RBRACK);
				setState(197);
				smartltlAtom(5);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(214);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(212);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new SmartltlAtomContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_smartltlAtom);
						setState(200);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(201);
						match(T_BIN);
						setState(202);
						smartltlAtom(5);
						}
						break;
					case 2:
						{
						_localctx = new SmartltlAtomContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_smartltlAtom);
						setState(203);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(204);
						match(IMP);
						setState(205);
						smartltlAtom(3);
						}
						break;
					case 3:
						{
						_localctx = new SmartltlAtomContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_smartltlAtom);
						setState(206);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(207);
						match(SEQ);
						setState(208);
						smartltlAtom(3);
						}
						break;
					case 4:
						{
						_localctx = new SmartltlAtomContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_smartltlAtom);
						setState(209);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(210);
						match(L_BIN);
						setState(211);
						smartltlAtom(2);
						}
						break;
					}
					} 
				}
				setState(216);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class InvAtomContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TerminalNode CONTRACT_INV() { return getToken(VParser.CONTRACT_INV, 0); }
		public TerminalNode LPAREN() { return getToken(VParser.LPAREN, 0); }
		public VarAccessContext varAccess() {
			return getRuleContext(VarAccessContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(VParser.COMMA, 0); }
		public List<ConstraintContext> constraint() {
			return getRuleContexts(ConstraintContext.class);
		}
		public ConstraintContext constraint(int i) {
			return getRuleContext(ConstraintContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(VParser.RPAREN, 0); }
		public TerminalNode PRE_SEP() { return getToken(VParser.PRE_SEP, 0); }
		public InvAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_invAtom; }
	}

	public final InvAtomContext invAtom() throws RecognitionException {
		InvAtomContext _localctx = new InvAtomContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_invAtom);
		try {
			setState(234);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(217);
				atom(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				match(CONTRACT_INV);
				setState(219);
				match(LPAREN);
				setState(220);
				varAccess(0);
				setState(221);
				match(COMMA);
				setState(222);
				constraint(0);
				setState(223);
				match(RPAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(225);
				match(CONTRACT_INV);
				setState(226);
				match(LPAREN);
				setState(227);
				varAccess(0);
				setState(228);
				match(COMMA);
				setState(229);
				constraint(0);
				setState(230);
				match(PRE_SEP);
				setState(231);
				constraint(0);
				setState(232);
				match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public TerminalNode ATOM_PRE_LOC() { return getToken(VParser.ATOM_PRE_LOC, 0); }
		public TerminalNode LPAREN() { return getToken(VParser.LPAREN, 0); }
		public AtomFnContext atomFn() {
			return getRuleContext(AtomFnContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(VParser.COMMA, 0); }
		public List<ConstraintContext> constraint() {
			return getRuleContexts(ConstraintContext.class);
		}
		public ConstraintContext constraint(int i) {
			return getRuleContext(ConstraintContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(VParser.RPAREN, 0); }
		public TerminalNode ATOM_POST_LOC() { return getToken(VParser.ATOM_POST_LOC, 0); }
		public TerminalNode PRE_SEP() { return getToken(VParser.PRE_SEP, 0); }
		public TerminalNode LET() { return getToken(VParser.LET, 0); }
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public TerminalNode ASSN() { return getToken(VParser.ASSN, 0); }
		public TerminalNode LBRACK() { return getToken(VParser.LBRACK, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(VParser.RBRACK, 0); }
		public TerminalNode FOREACH() { return getToken(VParser.FOREACH, 0); }
		public TerminalNode IN() { return getToken(VParser.IN, 0); }
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public TerminalNode SENT() { return getToken(VParser.SENT, 0); }
		public TerminalNode L_UN() { return getToken(VParser.L_UN, 0); }
		public TerminalNode L_BIN() { return getToken(VParser.L_BIN, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	}

	public final AtomContext atom() throws RecognitionException {
		return atom(0);
	}

	private AtomContext atom(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AtomContext _localctx = new AtomContext(_ctx, _parentState);
		AtomContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_atom, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(237);
				match(ATOM_PRE_LOC);
				setState(238);
				match(LPAREN);
				setState(239);
				atomFn();
				setState(240);
				match(COMMA);
				setState(241);
				constraint(0);
				setState(242);
				match(RPAREN);
				}
				break;
			case 2:
				{
				setState(244);
				match(ATOM_PRE_LOC);
				setState(245);
				match(LPAREN);
				setState(246);
				atomFn();
				setState(247);
				match(RPAREN);
				}
				break;
			case 3:
				{
				setState(249);
				match(ATOM_POST_LOC);
				setState(250);
				match(LPAREN);
				setState(251);
				atomFn();
				setState(252);
				match(COMMA);
				setState(253);
				constraint(0);
				setState(254);
				match(PRE_SEP);
				setState(255);
				constraint(0);
				setState(256);
				match(RPAREN);
				}
				break;
			case 4:
				{
				setState(258);
				match(ATOM_POST_LOC);
				setState(259);
				match(LPAREN);
				setState(260);
				atomFn();
				setState(261);
				match(COMMA);
				setState(262);
				constraint(0);
				setState(263);
				match(RPAREN);
				}
				break;
			case 5:
				{
				setState(265);
				match(ATOM_POST_LOC);
				setState(266);
				match(LPAREN);
				setState(267);
				atomFn();
				setState(268);
				match(RPAREN);
				}
				break;
			case 6:
				{
				setState(270);
				match(LET);
				setState(271);
				match(LPAREN);
				setState(272);
				ident();
				setState(273);
				match(ASSN);
				setState(274);
				match(LBRACK);
				setState(275);
				params();
				setState(276);
				match(RBRACK);
				setState(277);
				match(RPAREN);
				}
				break;
			case 7:
				{
				setState(279);
				match(FOREACH);
				setState(280);
				match(LPAREN);
				setState(281);
				ident();
				setState(282);
				match(IN);
				setState(283);
				ident();
				setState(284);
				match(COMMA);
				setState(285);
				atom(0);
				setState(286);
				match(RPAREN);
				}
				break;
			case 8:
				{
				setState(288);
				match(SENT);
				setState(289);
				match(LPAREN);
				setState(290);
				constraint(0);
				setState(291);
				match(RPAREN);
				}
				break;
			case 9:
				{
				setState(293);
				match(LPAREN);
				setState(294);
				atom(0);
				setState(295);
				match(RPAREN);
				}
				break;
			case 10:
				{
				setState(297);
				match(L_UN);
				setState(298);
				atom(2);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(306);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AtomContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_atom);
					setState(301);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(302);
					match(L_BIN);
					setState(303);
					atom(2);
					}
					} 
				}
				setState(308);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AtomFnContext extends ParserRuleContext {
		public AtomFnNameContext atomFnName() {
			return getRuleContext(AtomFnNameContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(VParser.LPAREN, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(VParser.RPAREN, 0); }
		public AtomFnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomFn; }
	}

	public final AtomFnContext atomFn() throws RecognitionException {
		AtomFnContext _localctx = new AtomFnContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_atomFn);
		try {
			setState(315);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(309);
				atomFnName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(310);
				atomFnName();
				setState(311);
				match(LPAREN);
				setState(312);
				params();
				setState(313);
				match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomFnNameContext extends ParserRuleContext {
		public VarAccessContext varAccess() {
			return getRuleContext(VarAccessContext.class,0);
		}
		public TerminalNode DOT() { return getToken(VParser.DOT, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode WILDCARD() { return getToken(VParser.WILDCARD, 0); }
		public AtomFnNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomFnName; }
	}

	public final AtomFnNameContext atomFnName() throws RecognitionException {
		AtomFnNameContext _localctx = new AtomFnNameContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_atomFnName);
		try {
			setState(325);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(317);
				varAccess(0);
				setState(318);
				match(DOT);
				setState(319);
				ident();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(321);
				varAccess(0);
				setState(322);
				match(DOT);
				setState(323);
				match(WILDCARD);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(VParser.COMMA, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TerminalNode NUM() { return getToken(VParser.NUM, 0); }
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_params);
		try {
			setState(337);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(327);
				ident();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(328);
				ident();
				setState(329);
				match(COMMA);
				setState(330);
				params();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(332);
				match(NUM);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(333);
				match(NUM);
				setState(334);
				match(COMMA);
				setState(335);
				params();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstraintContext extends ParserRuleContext {
		public BoolExprContext boolExpr() {
			return getRuleContext(BoolExprContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(VParser.LPAREN, 0); }
		public List<ConstraintContext> constraint() {
			return getRuleContexts(ConstraintContext.class);
		}
		public ConstraintContext constraint(int i) {
			return getRuleContext(ConstraintContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(VParser.RPAREN, 0); }
		public TerminalNode L_BIN() { return getToken(VParser.L_BIN, 0); }
		public TerminalNode IMP() { return getToken(VParser.IMP, 0); }
		public ConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint; }
	}

	public final ConstraintContext constraint() throws RecognitionException {
		return constraint(0);
	}

	private ConstraintContext constraint(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConstraintContext _localctx = new ConstraintContext(_ctx, _parentState);
		ConstraintContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_constraint, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(340);
				boolExpr();
				}
				break;
			case 2:
				{
				setState(341);
				match(LPAREN);
				setState(342);
				constraint(0);
				setState(343);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(355);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(353);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new ConstraintContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_constraint);
						setState(347);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(348);
						match(L_BIN);
						setState(349);
						constraint(3);
						}
						break;
					case 2:
						{
						_localctx = new ConstraintContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_constraint);
						setState(350);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(351);
						match(IMP);
						setState(352);
						constraint(1);
						}
						break;
					}
					} 
				}
				setState(357);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BoolExprContext extends ParserRuleContext {
		public VarOrNumContext varOrNum() {
			return getRuleContext(VarOrNumContext.class,0);
		}
		public TerminalNode L_UN() { return getToken(VParser.L_UN, 0); }
		public BoolExprContext boolExpr() {
			return getRuleContext(BoolExprContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(VParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(VParser.RPAREN, 0); }
		public List<ArithExprContext> arithExpr() {
			return getRuleContexts(ArithExprContext.class);
		}
		public ArithExprContext arithExpr(int i) {
			return getRuleContext(ArithExprContext.class,i);
		}
		public TerminalNode C_BIN() { return getToken(VParser.C_BIN, 0); }
		public BoolExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolExpr; }
	}

	public final BoolExprContext boolExpr() throws RecognitionException {
		BoolExprContext _localctx = new BoolExprContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_boolExpr);
		try {
			setState(369);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(358);
				varOrNum();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(359);
				match(L_UN);
				setState(360);
				boolExpr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(361);
				match(LPAREN);
				setState(362);
				boolExpr();
				setState(363);
				match(RPAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(365);
				arithExpr(0);
				setState(366);
				match(C_BIN);
				setState(367);
				arithExpr(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArithExprContext extends ParserRuleContext {
		public VarOrNumContext varOrNum() {
			return getRuleContext(VarOrNumContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(VParser.LPAREN, 0); }
		public List<ArithExprContext> arithExpr() {
			return getRuleContexts(ArithExprContext.class);
		}
		public ArithExprContext arithExpr(int i) {
			return getRuleContext(ArithExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(VParser.RPAREN, 0); }
		public TerminalNode A1_BIN() { return getToken(VParser.A1_BIN, 0); }
		public TerminalNode A2_BIN() { return getToken(VParser.A2_BIN, 0); }
		public ArithExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithExpr; }
	}

	public final ArithExprContext arithExpr() throws RecognitionException {
		return arithExpr(0);
	}

	private ArithExprContext arithExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArithExprContext _localctx = new ArithExprContext(_ctx, _parentState);
		ArithExprContext _prevctx = _localctx;
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_arithExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FSUM:
			case ATOM_PRE_LOC:
			case ATOM_POST_LOC:
			case IDENTIFIER:
			case NUM:
			case NEG_NUM:
				{
				setState(372);
				varOrNum();
				}
				break;
			case LPAREN:
				{
				setState(373);
				match(LPAREN);
				setState(374);
				arithExpr(0);
				setState(375);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(387);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(385);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						_localctx = new ArithExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithExpr);
						setState(379);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(380);
						match(A1_BIN);
						setState(381);
						arithExpr(3);
						}
						break;
					case 2:
						{
						_localctx = new ArithExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arithExpr);
						setState(382);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(383);
						match(A2_BIN);
						setState(384);
						arithExpr(2);
						}
						break;
					}
					} 
				}
				setState(389);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FnCallContext extends ParserRuleContext {
		public TerminalNode FSUM() { return getToken(VParser.FSUM, 0); }
		public TerminalNode LPAREN() { return getToken(VParser.LPAREN, 0); }
		public AtomFnContext atomFn() {
			return getRuleContext(AtomFnContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(VParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(VParser.COMMA, i);
		}
		public VarOrNumContext varOrNum() {
			return getRuleContext(VarOrNumContext.class,0);
		}
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(VParser.RPAREN, 0); }
		public FnNameContext fnName() {
			return getRuleContext(FnNameContext.class,0);
		}
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public FnCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fnCall; }
	}

	public final FnCallContext fnCall() throws RecognitionException {
		FnCallContext _localctx = new FnCallContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_fnCall);
		try {
			setState(404);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FSUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(390);
				match(FSUM);
				setState(391);
				match(LPAREN);
				setState(392);
				atomFn();
				setState(393);
				match(COMMA);
				setState(394);
				varOrNum();
				setState(395);
				match(COMMA);
				setState(396);
				constraint(0);
				setState(397);
				match(RPAREN);
				}
				break;
			case ATOM_PRE_LOC:
			case ATOM_POST_LOC:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(399);
				fnName(0);
				setState(400);
				match(LPAREN);
				setState(401);
				argList();
				setState(402);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FnNameContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public FnNameContext fnName() {
			return getRuleContext(FnNameContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(VParser.LPAREN, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(VParser.RPAREN, 0); }
		public TerminalNode DOT() { return getToken(VParser.DOT, 0); }
		public TerminalNode LBRACK() { return getToken(VParser.LBRACK, 0); }
		public ArithExprContext arithExpr() {
			return getRuleContext(ArithExprContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(VParser.RBRACK, 0); }
		public FnNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fnName; }
	}

	public final FnNameContext fnName() throws RecognitionException {
		return fnName(0);
	}

	private FnNameContext fnName(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FnNameContext _localctx = new FnNameContext(_ctx, _parentState);
		FnNameContext _prevctx = _localctx;
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_fnName, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(407);
			ident();
			}
			_ctx.stop = _input.LT(-1);
			setState(428);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(426);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						_localctx = new FnNameContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_fnName);
						setState(409);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(410);
						match(LPAREN);
						setState(411);
						argList();
						setState(412);
						match(RPAREN);
						setState(413);
						match(DOT);
						setState(414);
						ident();
						}
						break;
					case 2:
						{
						_localctx = new FnNameContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_fnName);
						setState(416);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(417);
						match(LBRACK);
						setState(418);
						arithExpr(0);
						setState(419);
						match(RBRACK);
						setState(420);
						match(DOT);
						setState(421);
						ident();
						}
						break;
					case 3:
						{
						_localctx = new FnNameContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_fnName);
						setState(423);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(424);
						match(DOT);
						setState(425);
						ident();
						}
						break;
					}
					} 
				}
				setState(430);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ArgListContext extends ParserRuleContext {
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public ArithExprContext arithExpr() {
			return getRuleContext(ArithExprContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(VParser.COMMA, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_argList);
		try {
			setState(442);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(431);
				constraint(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(432);
				arithExpr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(433);
				arithExpr(0);
				setState(434);
				match(COMMA);
				setState(435);
				argList();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(437);
				constraint(0);
				setState(438);
				match(COMMA);
				setState(439);
				argList();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(VParser.IDENTIFIER, 0); }
		public TerminalNode ATOM_PRE_LOC() { return getToken(VParser.ATOM_PRE_LOC, 0); }
		public TerminalNode ATOM_POST_LOC() { return getToken(VParser.ATOM_POST_LOC, 0); }
		public IdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ident; }
	}

	public final IdentContext ident() throws RecognitionException {
		IdentContext _localctx = new IdentContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_ident);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ATOM_PRE_LOC) | (1L << ATOM_POST_LOC) | (1L << IDENTIFIER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarOrNumContext extends ParserRuleContext {
		public VarAccessContext varAccess() {
			return getRuleContext(VarAccessContext.class,0);
		}
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
		}
		public VarOrNumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varOrNum; }
	}

	public final VarOrNumContext varOrNum() throws RecognitionException {
		VarOrNumContext _localctx = new VarOrNumContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_varOrNum);
		try {
			setState(448);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FSUM:
			case ATOM_PRE_LOC:
			case ATOM_POST_LOC:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(446);
				varAccess(0);
				}
				break;
			case NUM:
			case NEG_NUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(447);
				num();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(VParser.NUM, 0); }
		public TerminalNode NEG_NUM() { return getToken(VParser.NEG_NUM, 0); }
		public NumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_num; }
	}

	public final NumContext num() throws RecognitionException {
		NumContext _localctx = new NumContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_num);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(450);
			_la = _input.LA(1);
			if ( !(_la==NUM || _la==NEG_NUM) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarAccessContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public FnCallContext fnCall() {
			return getRuleContext(FnCallContext.class,0);
		}
		public VarAccessContext varAccess() {
			return getRuleContext(VarAccessContext.class,0);
		}
		public TerminalNode LBRACK() { return getToken(VParser.LBRACK, 0); }
		public ArithExprContext arithExpr() {
			return getRuleContext(ArithExprContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(VParser.RBRACK, 0); }
		public TerminalNode DOT() { return getToken(VParser.DOT, 0); }
		public VarAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varAccess; }
	}

	public final VarAccessContext varAccess() throws RecognitionException {
		return varAccess(0);
	}

	private VarAccessContext varAccess(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		VarAccessContext _localctx = new VarAccessContext(_ctx, _parentState);
		VarAccessContext _prevctx = _localctx;
		int _startState = 68;
		enterRecursionRule(_localctx, 68, RULE_varAccess, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(453);
				ident();
				}
				break;
			case 2:
				{
				setState(454);
				fnCall();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(467);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(465);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
					case 1:
						{
						_localctx = new VarAccessContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_varAccess);
						setState(457);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(458);
						match(LBRACK);
						setState(459);
						arithExpr(0);
						setState(460);
						match(RBRACK);
						}
						break;
					case 2:
						{
						_localctx = new VarAccessContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_varAccess);
						setState(462);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(463);
						match(DOT);
						setState(464);
						ident();
						}
						break;
					}
					} 
				}
				setState(469);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 19:
			return smartltlAtom_sempred((SmartltlAtomContext)_localctx, predIndex);
		case 21:
			return atom_sempred((AtomContext)_localctx, predIndex);
		case 25:
			return constraint_sempred((ConstraintContext)_localctx, predIndex);
		case 27:
			return arithExpr_sempred((ArithExprContext)_localctx, predIndex);
		case 29:
			return fnName_sempred((FnNameContext)_localctx, predIndex);
		case 34:
			return varAccess_sempred((VarAccessContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean smartltlAtom_sempred(SmartltlAtomContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean atom_sempred(AtomContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean constraint_sempred(ConstraintContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean arithExpr_sempred(ArithExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 2);
		case 8:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean fnName_sempred(FnNameContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 4);
		case 10:
			return precpred(_ctx, 3);
		case 11:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean varAccess_sempred(VarAccessContext _localctx, int predIndex) {
		switch (predIndex) {
		case 12:
			return precpred(_ctx, 2);
		case 13:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u01d9\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\5\2X\n\2\3\3\3\3\5\3\\\n\3\3\3\5\3_\n\3\3\3\3\3\3\4\3\4"+
		"\5\4e\n\4\3\4\5\4h\n\4\3\4\3\4\3\5\3\5\5\5n\n\5\3\5\5\5q\n\5\3\5\3\5\3"+
		"\6\3\6\5\6w\n\6\3\6\3\6\3\7\3\7\5\7}\n\7\3\7\5\7\u0080\n\7\3\7\3\7\3\b"+
		"\3\b\3\b\3\b\5\b\u0088\n\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f"+
		"\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\22\5\22\u00aa\n\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u00b4\n\23\3\24\3\24\3\24\3\24\5\24\u00ba\n"+
		"\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5"+
		"\25\u00c9\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\7\25\u00d7\n\25\f\25\16\25\u00da\13\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u00ed"+
		"\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u012e\n\27\3\27\3\27\3\27"+
		"\7\27\u0133\n\27\f\27\16\27\u0136\13\27\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\5\30\u013e\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0148\n"+
		"\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0154\n\32"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u015c\n\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\7\33\u0164\n\33\f\33\16\33\u0167\13\33\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0174\n\34\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\5\35\u017c\n\35\3\35\3\35\3\35\3\35\3\35\3\35\7\35\u0184\n\35\f"+
		"\35\16\35\u0187\13\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\5\36\u0197\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\7\37"+
		"\u01ad\n\37\f\37\16\37\u01b0\13\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5"+
		" \u01bd\n \3!\3!\3\"\3\"\5\"\u01c3\n\"\3#\3#\3$\3$\3$\5$\u01ca\n$\3$\3"+
		"$\3$\3$\3$\3$\3$\3$\7$\u01d4\n$\f$\16$\u01d7\13$\3$\2\b(,\648<F%\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDF\2\4\4\2"+
		"\33\34##\3\2*+\2\u01f5\2W\3\2\2\2\4Y\3\2\2\2\6b\3\2\2\2\bk\3\2\2\2\nt"+
		"\3\2\2\2\fz\3\2\2\2\16\u0087\3\2\2\2\20\u0089\3\2\2\2\22\u008c\3\2\2\2"+
		"\24\u008f\3\2\2\2\26\u0092\3\2\2\2\30\u0095\3\2\2\2\32\u0098\3\2\2\2\34"+
		"\u009b\3\2\2\2\36\u009e\3\2\2\2 \u00a1\3\2\2\2\"\u00a9\3\2\2\2$\u00b3"+
		"\3\2\2\2&\u00b9\3\2\2\2(\u00c8\3\2\2\2*\u00ec\3\2\2\2,\u012d\3\2\2\2."+
		"\u013d\3\2\2\2\60\u0147\3\2\2\2\62\u0153\3\2\2\2\64\u015b\3\2\2\2\66\u0173"+
		"\3\2\2\28\u017b\3\2\2\2:\u0196\3\2\2\2<\u0198\3\2\2\2>\u01bc\3\2\2\2@"+
		"\u01be\3\2\2\2B\u01c2\3\2\2\2D\u01c4\3\2\2\2F\u01c9\3\2\2\2HI\5\4\3\2"+
		"IJ\7\2\2\3JX\3\2\2\2KL\5\6\4\2LM\7\2\2\3MX\3\2\2\2NO\5\b\5\2OP\7\2\2\3"+
		"PX\3\2\2\2QR\5\n\6\2RS\7\2\2\3SX\3\2\2\2TU\5\f\7\2UV\7\2\2\3VX\3\2\2\2"+
		"WH\3\2\2\2WK\3\2\2\2WN\3\2\2\2WQ\3\2\2\2WT\3\2\2\2X\3\3\2\2\2Y[\5\16\b"+
		"\2Z\\\5\20\t\2[Z\3\2\2\2[\\\3\2\2\2\\^\3\2\2\2]_\5\22\n\2^]\3\2\2\2^_"+
		"\3\2\2\2_`\3\2\2\2`a\5\24\13\2a\5\3\2\2\2bd\5\16\b\2ce\5\20\t\2dc\3\2"+
		"\2\2de\3\2\2\2eg\3\2\2\2fh\5\26\f\2gf\3\2\2\2gh\3\2\2\2hi\3\2\2\2ij\5"+
		"\30\r\2j\7\3\2\2\2km\5\16\b\2ln\5\20\t\2ml\3\2\2\2mn\3\2\2\2np\3\2\2\2"+
		"oq\5\34\17\2po\3\2\2\2pq\3\2\2\2qr\3\2\2\2rs\5\36\20\2s\t\3\2\2\2tv\5"+
		"\16\b\2uw\5\20\t\2vu\3\2\2\2vw\3\2\2\2wx\3\2\2\2xy\5 \21\2y\13\3\2\2\2"+
		"z|\5\16\b\2{}\5\20\t\2|{\3\2\2\2|}\3\2\2\2}\177\3\2\2\2~\u0080\5\26\f"+
		"\2\177~\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\5\32"+
		"\16\2\u0082\r\3\2\2\2\u0083\u0084\7\21\2\2\u0084\u0085\7\"\2\2\u0085\u0088"+
		"\5\16\b\2\u0086\u0088\3\2\2\2\u0087\u0083\3\2\2\2\u0087\u0086\3\2\2\2"+
		"\u0088\17\3\2\2\2\u0089\u008a\7\22\2\2\u008a\u008b\5$\23\2\u008b\21\3"+
		"\2\2\2\u008c\u008d\7\23\2\2\u008d\u008e\5,\27\2\u008e\23\3\2\2\2\u008f"+
		"\u0090\7\24\2\2\u0090\u0091\5,\27\2\u0091\25\3\2\2\2\u0092\u0093\7\25"+
		"\2\2\u0093\u0094\5\"\22\2\u0094\27\3\2\2\2\u0095\u0096\7\26\2\2\u0096"+
		"\u0097\5\"\22\2\u0097\31\3\2\2\2\u0098\u0099\7\27\2\2\u0099\u009a\5,\27"+
		"\2\u009a\33\3\2\2\2\u009b\u009c\7\30\2\2\u009c\u009d\5(\25\2\u009d\35"+
		"\3\2\2\2\u009e\u009f\7\31\2\2\u009f\u00a0\5(\25\2\u00a0\37\3\2\2\2\u00a1"+
		"\u00a2\7\32\2\2\u00a2\u00a3\5*\26\2\u00a3!\3\2\2\2\u00a4\u00aa\5,\27\2"+
		"\u00a5\u00a6\5,\27\2\u00a6\u00a7\7\f\2\2\u00a7\u00a8\5\"\22\2\u00a8\u00aa"+
		"\3\2\2\2\u00a9\u00a4\3\2\2\2\u00a9\u00a5\3\2\2\2\u00aa#\3\2\2\2\u00ab"+
		"\u00ac\5&\24\2\u00ac\u00ad\5@!\2\u00ad\u00b4\3\2\2\2\u00ae\u00af\5&\24"+
		"\2\u00af\u00b0\5@!\2\u00b0\u00b1\7\7\2\2\u00b1\u00b2\5$\23\2\u00b2\u00b4"+
		"\3\2\2\2\u00b3\u00ab\3\2\2\2\u00b3\u00ae\3\2\2\2\u00b4%\3\2\2\2\u00b5"+
		"\u00ba\7#\2\2\u00b6\u00b7\7#\2\2\u00b7\u00b8\7\5\2\2\u00b8\u00ba\7\6\2"+
		"\2\u00b9\u00b5\3\2\2\2\u00b9\u00b6\3\2\2\2\u00ba\'\3\2\2\2\u00bb\u00bc"+
		"\b\25\1\2\u00bc\u00c9\5,\27\2\u00bd\u00be\7\3\2\2\u00be\u00bf\5(\25\2"+
		"\u00bf\u00c0\7\4\2\2\u00c0\u00c9\3\2\2\2\u00c1\u00c2\7!\2\2\u00c2\u00c9"+
		"\5(\25\t\u00c3\u00c4\7)\2\2\u00c4\u00c9\5(\25\b\u00c5\u00c6\7\5\2\2\u00c6"+
		"\u00c7\7\6\2\2\u00c7\u00c9\5(\25\7\u00c8\u00bb\3\2\2\2\u00c8\u00bd\3\2"+
		"\2\2\u00c8\u00c1\3\2\2\2\u00c8\u00c3\3\2\2\2\u00c8\u00c5\3\2\2\2\u00c9"+
		"\u00d8\3\2\2\2\u00ca\u00cb\f\6\2\2\u00cb\u00cc\7 \2\2\u00cc\u00d7\5(\25"+
		"\7\u00cd\u00ce\f\5\2\2\u00ce\u00cf\7\37\2\2\u00cf\u00d7\5(\25\5\u00d0"+
		"\u00d1\f\4\2\2\u00d1\u00d2\7\f\2\2\u00d2\u00d7\5(\25\5\u00d3\u00d4\f\3"+
		"\2\2\u00d4\u00d5\7(\2\2\u00d5\u00d7\5(\25\4\u00d6\u00ca\3\2\2\2\u00d6"+
		"\u00cd\3\2\2\2\u00d6\u00d0\3\2\2\2\u00d6\u00d3\3\2\2\2\u00d7\u00da\3\2"+
		"\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9)\3\2\2\2\u00da\u00d8"+
		"\3\2\2\2\u00db\u00ed\5,\27\2\u00dc\u00dd\7\35\2\2\u00dd\u00de\7\3\2\2"+
		"\u00de\u00df\5F$\2\u00df\u00e0\7\7\2\2\u00e0\u00e1\5\64\33\2\u00e1\u00e2"+
		"\7\4\2\2\u00e2\u00ed\3\2\2\2\u00e3\u00e4\7\35\2\2\u00e4\u00e5\7\3\2\2"+
		"\u00e5\u00e6\5F$\2\u00e6\u00e7\7\7\2\2\u00e7\u00e8\5\64\33\2\u00e8\u00e9"+
		"\7\36\2\2\u00e9\u00ea\5\64\33\2\u00ea\u00eb\7\4\2\2\u00eb\u00ed\3\2\2"+
		"\2\u00ec\u00db\3\2\2\2\u00ec\u00dc\3\2\2\2\u00ec\u00e3\3\2\2\2\u00ed+"+
		"\3\2\2\2\u00ee\u00ef\b\27\1\2\u00ef\u00f0\7\33\2\2\u00f0\u00f1\7\3\2\2"+
		"\u00f1\u00f2\5.\30\2\u00f2\u00f3\7\7\2\2\u00f3\u00f4\5\64\33\2\u00f4\u00f5"+
		"\7\4\2\2\u00f5\u012e\3\2\2\2\u00f6\u00f7\7\33\2\2\u00f7\u00f8\7\3\2\2"+
		"\u00f8\u00f9\5.\30\2\u00f9\u00fa\7\4\2\2\u00fa\u012e\3\2\2\2\u00fb\u00fc"+
		"\7\34\2\2\u00fc\u00fd\7\3\2\2\u00fd\u00fe\5.\30\2\u00fe\u00ff\7\7\2\2"+
		"\u00ff\u0100\5\64\33\2\u0100\u0101\7\36\2\2\u0101\u0102\5\64\33\2\u0102"+
		"\u0103\7\4\2\2\u0103\u012e\3\2\2\2\u0104\u0105\7\34\2\2\u0105\u0106\7"+
		"\3\2\2\u0106\u0107\5.\30\2\u0107\u0108\7\7\2\2\u0108\u0109\5\64\33\2\u0109"+
		"\u010a\7\4\2\2\u010a\u012e\3\2\2\2\u010b\u010c\7\34\2\2\u010c\u010d\7"+
		"\3\2\2\u010d\u010e\5.\30\2\u010e\u010f\7\4\2\2\u010f\u012e\3\2\2\2\u0110"+
		"\u0111\7\16\2\2\u0111\u0112\7\3\2\2\u0112\u0113\5@!\2\u0113\u0114\7\r"+
		"\2\2\u0114\u0115\7\5\2\2\u0115\u0116\5\62\32\2\u0116\u0117\7\6\2\2\u0117"+
		"\u0118\7\4\2\2\u0118\u012e\3\2\2\2\u0119\u011a\7\17\2\2\u011a\u011b\7"+
		"\3\2\2\u011b\u011c\5@!\2\u011c\u011d\7\20\2\2\u011d\u011e\5@!\2\u011e"+
		"\u011f\7\7\2\2\u011f\u0120\5,\27\2\u0120\u0121\7\4\2\2\u0121\u012e\3\2"+
		"\2\2\u0122\u0123\7\b\2\2\u0123\u0124\7\3\2\2\u0124\u0125\5\64\33\2\u0125"+
		"\u0126\7\4\2\2\u0126\u012e\3\2\2\2\u0127\u0128\7\3\2\2\u0128\u0129\5,"+
		"\27\2\u0129\u012a\7\4\2\2\u012a\u012e\3\2\2\2\u012b\u012c\7)\2\2\u012c"+
		"\u012e\5,\27\4\u012d\u00ee\3\2\2\2\u012d\u00f6\3\2\2\2\u012d\u00fb\3\2"+
		"\2\2\u012d\u0104\3\2\2\2\u012d\u010b\3\2\2\2\u012d\u0110\3\2\2\2\u012d"+
		"\u0119\3\2\2\2\u012d\u0122\3\2\2\2\u012d\u0127\3\2\2\2\u012d\u012b\3\2"+
		"\2\2\u012e\u0134\3\2\2\2\u012f\u0130\f\3\2\2\u0130\u0131\7(\2\2\u0131"+
		"\u0133\5,\27\4\u0132\u012f\3\2\2\2\u0133\u0136\3\2\2\2\u0134\u0132\3\2"+
		"\2\2\u0134\u0135\3\2\2\2\u0135-\3\2\2\2\u0136\u0134\3\2\2\2\u0137\u013e"+
		"\5\60\31\2\u0138\u0139\5\60\31\2\u0139\u013a\7\3\2\2\u013a\u013b\5\62"+
		"\32\2\u013b\u013c\7\4\2\2\u013c\u013e\3\2\2\2\u013d\u0137\3\2\2\2\u013d"+
		"\u0138\3\2\2\2\u013e/\3\2\2\2\u013f\u0140\5F$\2\u0140\u0141\7\13\2\2\u0141"+
		"\u0142\5@!\2\u0142\u0148\3\2\2\2\u0143\u0144\5F$\2\u0144\u0145\7\13\2"+
		"\2\u0145\u0146\7\n\2\2\u0146\u0148\3\2\2\2\u0147\u013f\3\2\2\2\u0147\u0143"+
		"\3\2\2\2\u0148\61\3\2\2\2\u0149\u0154\5@!\2\u014a\u014b\5@!\2\u014b\u014c"+
		"\7\7\2\2\u014c\u014d\5\62\32\2\u014d\u0154\3\2\2\2\u014e\u0154\7*\2\2"+
		"\u014f\u0150\7*\2\2\u0150\u0151\7\7\2\2\u0151\u0154\5\62\32\2\u0152\u0154"+
		"\3\2\2\2\u0153\u0149\3\2\2\2\u0153\u014a\3\2\2\2\u0153\u014e\3\2\2\2\u0153"+
		"\u014f\3\2\2\2\u0153\u0152\3\2\2\2\u0154\63\3\2\2\2\u0155\u0156\b\33\1"+
		"\2\u0156\u015c\5\66\34\2\u0157\u0158\7\3\2\2\u0158\u0159\5\64\33\2\u0159"+
		"\u015a\7\4\2\2\u015a\u015c\3\2\2\2\u015b\u0155\3\2\2\2\u015b\u0157\3\2"+
		"\2\2\u015c\u0165\3\2\2\2\u015d\u015e\f\4\2\2\u015e\u015f\7(\2\2\u015f"+
		"\u0164\5\64\33\5\u0160\u0161\f\3\2\2\u0161\u0162\7\37\2\2\u0162\u0164"+
		"\5\64\33\3\u0163\u015d\3\2\2\2\u0163\u0160\3\2\2\2\u0164\u0167\3\2\2\2"+
		"\u0165\u0163\3\2\2\2\u0165\u0166\3\2\2\2\u0166\65\3\2\2\2\u0167\u0165"+
		"\3\2\2\2\u0168\u0174\5B\"\2\u0169\u016a\7)\2\2\u016a\u0174\5\66\34\2\u016b"+
		"\u016c\7\3\2\2\u016c\u016d\5\66\34\2\u016d\u016e\7\4\2\2\u016e\u0174\3"+
		"\2\2\2\u016f\u0170\58\35\2\u0170\u0171\7\'\2\2\u0171\u0172\58\35\2\u0172"+
		"\u0174\3\2\2\2\u0173\u0168\3\2\2\2\u0173\u0169\3\2\2\2\u0173\u016b\3\2"+
		"\2\2\u0173\u016f\3\2\2\2\u0174\67\3\2\2\2\u0175\u0176\b\35\1\2\u0176\u017c"+
		"\5B\"\2\u0177\u0178\7\3\2\2\u0178\u0179\58\35\2\u0179\u017a\7\4\2\2\u017a"+
		"\u017c\3\2\2\2\u017b\u0175\3\2\2\2\u017b\u0177\3\2\2\2\u017c\u0185\3\2"+
		"\2\2\u017d\u017e\f\4\2\2\u017e\u017f\7$\2\2\u017f\u0184\58\35\5\u0180"+
		"\u0181\f\3\2\2\u0181\u0182\7%\2\2\u0182\u0184\58\35\4\u0183\u017d\3\2"+
		"\2\2\u0183\u0180\3\2\2\2\u0184\u0187\3\2\2\2\u0185\u0183\3\2\2\2\u0185"+
		"\u0186\3\2\2\2\u01869\3\2\2\2\u0187\u0185\3\2\2\2\u0188\u0189\7\t\2\2"+
		"\u0189\u018a\7\3\2\2\u018a\u018b\5.\30\2\u018b\u018c\7\7\2\2\u018c\u018d"+
		"\5B\"\2\u018d\u018e\7\7\2\2\u018e\u018f\5\64\33\2\u018f\u0190\7\4\2\2"+
		"\u0190\u0197\3\2\2\2\u0191\u0192\5<\37\2\u0192\u0193\7\3\2\2\u0193\u0194"+
		"\5> \2\u0194\u0195\7\4\2\2\u0195\u0197\3\2\2\2\u0196\u0188\3\2\2\2\u0196"+
		"\u0191\3\2\2\2\u0197;\3\2\2\2\u0198\u0199\b\37\1\2\u0199\u019a\5@!\2\u019a"+
		"\u01ae\3\2\2\2\u019b\u019c\f\6\2\2\u019c\u019d\7\3\2\2\u019d\u019e\5>"+
		" \2\u019e\u019f\7\4\2\2\u019f\u01a0\7\13\2\2\u01a0\u01a1\5@!\2\u01a1\u01ad"+
		"\3\2\2\2\u01a2\u01a3\f\5\2\2\u01a3\u01a4\7\5\2\2\u01a4\u01a5\58\35\2\u01a5"+
		"\u01a6\7\6\2\2\u01a6\u01a7\7\13\2\2\u01a7\u01a8\5@!\2\u01a8\u01ad\3\2"+
		"\2\2\u01a9\u01aa\f\4\2\2\u01aa\u01ab\7\13\2\2\u01ab\u01ad\5@!\2\u01ac"+
		"\u019b\3\2\2\2\u01ac\u01a2\3\2\2\2\u01ac\u01a9\3\2\2\2\u01ad\u01b0\3\2"+
		"\2\2\u01ae\u01ac\3\2\2\2\u01ae\u01af\3\2\2\2\u01af=\3\2\2\2\u01b0\u01ae"+
		"\3\2\2\2\u01b1\u01bd\5\64\33\2\u01b2\u01bd\58\35\2\u01b3\u01b4\58\35\2"+
		"\u01b4\u01b5\7\7\2\2\u01b5\u01b6\5> \2\u01b6\u01bd\3\2\2\2\u01b7\u01b8"+
		"\5\64\33\2\u01b8\u01b9\7\7\2\2\u01b9\u01ba\5> \2\u01ba\u01bd\3\2\2\2\u01bb"+
		"\u01bd\3\2\2\2\u01bc\u01b1\3\2\2\2\u01bc\u01b2\3\2\2\2\u01bc\u01b3\3\2"+
		"\2\2\u01bc\u01b7\3\2\2\2\u01bc\u01bb\3\2\2\2\u01bd?\3\2\2\2\u01be\u01bf"+
		"\t\2\2\2\u01bfA\3\2\2\2\u01c0\u01c3\5F$\2\u01c1\u01c3\5D#\2\u01c2\u01c0"+
		"\3\2\2\2\u01c2\u01c1\3\2\2\2\u01c3C\3\2\2\2\u01c4\u01c5\t\3\2\2\u01c5"+
		"E\3\2\2\2\u01c6\u01c7\b$\1\2\u01c7\u01ca\5@!\2\u01c8\u01ca\5:\36\2\u01c9"+
		"\u01c6\3\2\2\2\u01c9\u01c8\3\2\2\2\u01ca\u01d5\3\2\2\2\u01cb\u01cc\f\4"+
		"\2\2\u01cc\u01cd\7\5\2\2\u01cd\u01ce\58\35\2\u01ce\u01cf\7\6\2\2\u01cf"+
		"\u01d4\3\2\2\2\u01d0\u01d1\f\3\2\2\u01d1\u01d2\7\13\2\2\u01d2\u01d4\5"+
		"@!\2\u01d3\u01cb\3\2\2\2\u01d3\u01d0\3\2\2\2\u01d4\u01d7\3\2\2\2\u01d5"+
		"\u01d3\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6G\3\2\2\2\u01d7\u01d5\3\2\2\2"+
		"(W[^dgmpv|\177\u0087\u00a9\u00b3\u00b9\u00c8\u00d6\u00d8\u00ec\u012d\u0134"+
		"\u013d\u0147\u0153\u015b\u0163\u0165\u0173\u017b\u0183\u0185\u0196\u01ac"+
		"\u01ae\u01bc\u01c2\u01c9\u01d3\u01d5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}