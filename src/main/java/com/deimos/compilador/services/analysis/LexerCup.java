/* The following code was generated by JFlex 1.4.3 on 7/02/22 06:28 PM */

/* JFlex example: partial Java language lexer specification */

package com.deimos.compilador.services.analysis;
import com.deimos.compilador.services.ErrorHandlerService;
import com.deimos.compilador.model.errors.ErrorType;
import com.deimos.compilador.model.errors.CompilationError;
import java.util.List;

import java_cup.runtime.Symbol;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 7/02/22 06:28 PM from the specification file
 * <tt>C:/Users/arcin/Documents/NetBeansProjects/compilador/src/main/java/com/deimos/compilador/services/analysis/LexerCup.flex</tt>
 */
class LexerCup implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int STRING = 2;
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1, 1
  };

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = {
     0,  0,  0,  0,  0,  0,  0,  0,  0,  5,  4,  0,  5,  3,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
    46, 42, 31,  0,  0, 40, 45,  0, 36, 37,  7, 38, 32, 39,  0,  6, 
     8,  2,  2,  2,  2,  2,  2,  2,  2,  2,  0, 33, 44, 41, 43,  0, 
     0,  9,  9,  9,  9,  9,  9,  9,  9,  9,  9,  9,  9,  9,  9,  9, 
     9,  9, 29,  9,  9,  9,  9, 30,  9,  9,  9,  0, 48,  0,  0,  1, 
     0, 14, 25, 26, 28, 19, 20, 13, 24, 16,  1, 27, 21, 15, 17, 12, 
    10,  1, 11, 22, 18,  1,  1, 23,  1,  1,  1, 34, 47, 35,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0
  };

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\1\2\1\3\3\4\1\5\1\6\1\3"+
    "\13\2\1\7\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\1\1\22\1\23\2\1"+
    "\1\24\1\1\1\25\1\26\2\0\1\4\1\0\1\27"+
    "\1\30\1\31\1\32\7\2\1\33\12\2\1\34\1\35"+
    "\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\0"+
    "\1\45\1\46\1\47\1\50\1\51\1\52\2\0\7\2"+
    "\1\53\2\2\1\54\11\2\1\55\1\0\1\4\5\2"+
    "\1\56\1\57\1\2\1\60\3\2\1\61\6\2\1\62"+
    "\1\2\1\63\2\2\1\64\1\2\1\65\1\66\1\67"+
    "\1\2\1\70\3\2\1\71\1\2\1\72\1\2\1\73"+
    "\1\74\1\2\1\75\1\76\1\77";

  private static int [] zzUnpackAction() {
    int [] result = new int[153];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\61\0\142\0\223\0\304\0\365\0\u0126\0\142"+
    "\0\u0157\0\u0188\0\u01b9\0\u01ea\0\u021b\0\u024c\0\u027d\0\u02ae"+
    "\0\u02df\0\u0310\0\u0341\0\u0372\0\u03a3\0\u03d4\0\142\0\142"+
    "\0\142\0\142\0\142\0\142\0\142\0\u0405\0\u0436\0\u0467"+
    "\0\u0498\0\u04c9\0\u04fa\0\u052b\0\u055c\0\u058d\0\u05be\0\u0126"+
    "\0\142\0\u05ef\0\u0126\0\u0620\0\u0651\0\u0682\0\142\0\142"+
    "\0\u01b9\0\223\0\u06b3\0\u06e4\0\u0715\0\u0746\0\u0777\0\u07a8"+
    "\0\u07d9\0\223\0\u080a\0\u083b\0\u086c\0\u089d\0\u08ce\0\u08ff"+
    "\0\u0930\0\u0961\0\u0992\0\u09c3\0\142\0\142\0\142\0\142"+
    "\0\142\0\142\0\142\0\142\0\142\0\u09f4\0\142\0\142"+
    "\0\142\0\142\0\142\0\142\0\u0a25\0\u0a56\0\u0a87\0\u0ab8"+
    "\0\u0ae9\0\u0b1a\0\u0b4b\0\u0b7c\0\u0bad\0\223\0\u0bde\0\u0c0f"+
    "\0\223\0\u0c40\0\u0c71\0\u0ca2\0\u0cd3\0\u0d04\0\u0d35\0\u0d66"+
    "\0\u0d97\0\u0dc8\0\142\0\u0df9\0\u0a25\0\u0e2a\0\u0e5b\0\u0e8c"+
    "\0\u0ebd\0\u0eee\0\223\0\223\0\u0f1f\0\223\0\u0f50\0\u0f81"+
    "\0\u0fb2\0\223\0\u0fe3\0\u1014\0\u1045\0\u1076\0\u10a7\0\u10d8"+
    "\0\223\0\u1109\0\223\0\u113a\0\u116b\0\223\0\u119c\0\223"+
    "\0\223\0\223\0\u11cd\0\223\0\u11fe\0\u122f\0\u1260\0\223"+
    "\0\u1291\0\223\0\u12c2\0\223\0\223\0\u12f3\0\223\0\223"+
    "\0\223";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[153];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12"+
    "\1\13\1\14\1\15\3\4\1\16\1\17\1\20\2\4"+
    "\1\21\1\22\1\4\1\23\1\24\1\4\1\25\2\4"+
    "\1\26\2\14\1\27\1\30\1\31\1\32\1\33\1\34"+
    "\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44"+
    "\1\45\1\10\1\46\1\3\3\47\1\3\1\50\32\47"+
    "\1\51\20\47\1\52\62\0\2\4\5\0\27\4\24\0"+
    "\1\5\5\0\1\5\54\0\1\10\54\0\4\53\1\0"+
    "\32\53\1\54\21\53\6\0\1\55\1\56\41\0\1\57"+
    "\60\0\1\60\11\0\1\61\5\0\1\61\51\0\1\4"+
    "\1\62\5\0\1\62\26\4\23\0\2\4\5\0\3\4"+
    "\1\63\23\4\23\0\2\4\5\0\21\4\1\64\3\4"+
    "\1\65\1\66\23\0\2\4\5\0\4\4\1\67\22\4"+
    "\23\0\2\4\5\0\11\4\1\70\1\71\1\4\1\72"+
    "\12\4\23\0\2\4\5\0\15\4\1\73\11\4\23\0"+
    "\2\4\5\0\4\4\1\74\10\4\1\75\11\4\23\0"+
    "\2\4\5\0\12\4\1\76\14\4\23\0\2\4\5\0"+
    "\6\4\1\77\11\4\1\100\6\4\23\0\2\4\5\0"+
    "\3\4\1\101\1\102\22\4\23\0\2\4\5\0\25\4"+
    "\1\103\1\104\70\0\1\105\2\0\1\106\56\0\1\107"+
    "\1\0\1\110\60\0\1\111\60\0\1\112\60\0\1\113"+
    "\60\0\1\114\60\0\1\115\64\0\1\116\62\0\1\117"+
    "\1\0\3\47\2\0\32\47\1\0\20\47\14\0\1\120"+
    "\5\0\1\121\1\122\14\0\1\123\21\0\4\54\1\124"+
    "\32\54\1\0\21\54\3\55\1\6\1\10\54\55\7\125"+
    "\1\126\51\125\1\0\2\4\5\0\4\4\1\127\3\4"+
    "\1\130\16\4\23\0\2\4\5\0\16\4\1\131\10\4"+
    "\23\0\2\4\5\0\13\4\1\132\13\4\23\0\2\4"+
    "\5\0\3\4\1\133\23\4\23\0\2\4\5\0\24\4"+
    "\1\134\2\4\23\0\2\4\5\0\10\4\1\135\1\4"+
    "\1\136\14\4\23\0\2\4\5\0\13\4\1\137\13\4"+
    "\23\0\2\4\5\0\16\4\1\140\10\4\23\0\2\4"+
    "\5\0\3\4\1\141\23\4\23\0\2\4\5\0\4\4"+
    "\1\142\22\4\23\0\2\4\5\0\3\4\1\143\2\4"+
    "\1\144\20\4\23\0\2\4\5\0\10\4\1\145\16\4"+
    "\23\0\2\4\5\0\10\4\1\146\16\4\23\0\2\4"+
    "\5\0\13\4\1\147\13\4\23\0\2\4\5\0\4\4"+
    "\1\150\22\4\23\0\2\4\5\0\13\4\1\151\13\4"+
    "\23\0\2\4\5\0\3\4\1\152\23\4\100\0\1\153"+
    "\2\0\7\125\1\154\57\125\1\155\1\154\51\125\1\0"+
    "\2\4\5\0\5\4\1\156\21\4\23\0\2\4\5\0"+
    "\11\4\1\157\15\4\23\0\2\4\5\0\12\4\1\160"+
    "\14\4\23\0\2\4\5\0\6\4\1\161\20\4\23\0"+
    "\2\4\5\0\10\4\1\162\16\4\23\0\2\4\5\0"+
    "\13\4\1\163\13\4\23\0\2\4\5\0\12\4\1\164"+
    "\14\4\23\0\2\4\5\0\3\4\1\165\23\4\23\0"+
    "\2\4\5\0\13\4\1\166\13\4\23\0\2\4\5\0"+
    "\6\4\1\167\20\4\23\0\2\4\5\0\10\4\1\170"+
    "\16\4\23\0\2\4\5\0\3\4\1\171\23\4\23\0"+
    "\2\4\5\0\12\4\1\172\14\4\23\0\2\4\5\0"+
    "\15\4\1\173\11\4\23\0\2\4\5\0\6\4\1\174"+
    "\20\4\23\0\2\4\5\0\15\4\1\175\11\4\23\0"+
    "\2\4\5\0\6\4\1\176\20\4\23\0\2\4\5\0"+
    "\10\4\1\177\16\4\22\0\6\125\1\10\1\154\51\125"+
    "\1\0\2\4\5\0\3\4\1\200\23\4\23\0\2\4"+
    "\5\0\12\4\1\201\14\4\23\0\2\4\5\0\3\4"+
    "\1\202\23\4\23\0\2\4\5\0\24\4\1\203\2\4"+
    "\23\0\2\4\5\0\12\4\1\204\14\4\23\0\2\4"+
    "\5\0\6\4\1\205\20\4\23\0\2\4\5\0\12\4"+
    "\1\206\14\4\23\0\2\4\5\0\11\4\1\207\15\4"+
    "\23\0\2\4\5\0\12\4\1\210\14\4\23\0\2\4"+
    "\5\0\13\4\1\211\13\4\23\0\2\4\5\0\23\4"+
    "\1\212\3\4\23\0\2\4\5\0\13\4\1\213\13\4"+
    "\23\0\2\4\5\0\24\4\1\214\2\4\23\0\2\4"+
    "\5\0\12\4\1\215\14\4\23\0\2\4\5\0\6\4"+
    "\1\216\20\4\23\0\2\4\5\0\6\4\1\217\20\4"+
    "\23\0\2\4\5\0\13\4\1\220\13\4\23\0\2\4"+
    "\5\0\12\4\1\221\14\4\23\0\2\4\5\0\5\4"+
    "\1\222\21\4\23\0\2\4\5\0\6\4\1\223\20\4"+
    "\23\0\2\4\5\0\13\4\1\224\13\4\23\0\2\4"+
    "\5\0\7\4\1\225\17\4\23\0\2\4\5\0\22\4"+
    "\1\226\4\4\23\0\2\4\5\0\13\4\1\227\13\4"+
    "\23\0\2\4\5\0\11\4\1\230\15\4\23\0\2\4"+
    "\5\0\12\4\1\231\14\4\22\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4900];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\11\4\1\1\11\16\1\7\11\13\1\1\11"+
    "\1\1\2\0\1\1\1\0\2\11\24\1\11\11\1\0"+
    "\6\11\2\0\24\1\1\11\1\0\55\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[153];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  StringBuffer string = new StringBuffer();

  private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
  }
  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
  }

    private void addLexicalError(String id, int line, String message, String content){
       List<CompilationError> errors = ErrorHandlerService.compilationErrors.getErrors();
       CompilationError lexicalError = new CompilationError(id, message, content, ErrorType.LEXICAL, line);
       errors.add(lexicalError); 
    }

    private static final String INVALID_CHARACTER_ERROR_CODE = "001";
    private static final String INVALID_NUMBER_ERROR_CODE = "002";
    private static final String UNCLOSED_STRING_ERROR_CODE = "014";

    private static final String UNCLOSED_STRING_MESSAGE = "Unclosed string literal";
    private static final String INVALID_CHARACTER_MESSAGE = "Invalid character";
    private static final String INVALID_NUMBER_MESSAGE = "Invalid number";


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  LexerCup(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  LexerCup(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 4: 
          { /* ignore */
          }
        case 64: break;
        case 24: 
          { return symbol(sym.ASSIGNMENT_MULTIPLICATION);
          }
        case 65: break;
        case 25: 
          { addLexicalError(INVALID_NUMBER_ERROR_CODE, yyline+1, INVALID_NUMBER_MESSAGE, yytext()); return symbol(sym.INVALID_NUMBER);
          }
        case 66: break;
        case 12: 
          { return symbol(sym.LPAR);
          }
        case 67: break;
        case 23: 
          { return symbol(sym.ASSIGNMENT_DIVISION);
          }
        case 68: break;
        case 40: 
          { string.append('\t');
          }
        case 69: break;
        case 47: 
          { return symbol(sym.INIT);
          }
        case 70: break;
        case 36: 
          { return symbol(sym.LESS_THAN_OR_EQUAL_TO);
          }
        case 71: break;
        case 61: 
          { return symbol(sym.ITERATE);
          }
        case 72: break;
        case 7: 
          { string.setLength(0); yybegin(STRING);
          }
        case 73: break;
        case 43: 
          { return symbol(sym.INT);
          }
        case 74: break;
        case 13: 
          { return symbol(sym.RPAR);
          }
        case 75: break;
        case 10: 
          { return symbol(sym.LBRACKET);
          }
        case 76: break;
        case 45: 
          { return symbol(sym.AND);
          }
        case 77: break;
        case 1: 
          { addLexicalError(INVALID_CHARACTER_ERROR_CODE, yyline+1, INVALID_CHARACTER_MESSAGE, yytext()); return symbol(sym.ERROR);
          }
        case 78: break;
        case 18: 
          { return symbol(sym.GREATER_THAN);
          }
        case 79: break;
        case 22: 
          { string.append('\\');
          }
        case 80: break;
        case 33: 
          { return symbol(sym.EQUAL_TO);
          }
        case 81: break;
        case 34: 
          { return symbol(sym.NOT_EQUAL);
          }
        case 82: break;
        case 38: 
          { string.append('\r');
          }
        case 83: break;
        case 30: 
          { return symbol(sym.DECREMENT);
          }
        case 84: break;
        case 3: 
          { return symbol(sym.INTEGER_LITERAL, new Integer(yytext()));
          }
        case 85: break;
        case 28: 
          { return symbol(sym.INCREMENT);
          }
        case 86: break;
        case 2: 
          { return symbol(sym.IDENTIFIER, yytext());
          }
        case 87: break;
        case 29: 
          { return symbol(sym.ASSIGNMENT_ADDITION);
          }
        case 88: break;
        case 11: 
          { return symbol(sym.RBRACKET);
          }
        case 89: break;
        case 57: 
          { return symbol(sym.A_WRITE);
          }
        case 90: break;
        case 48: 
          { return symbol(sym.ELSE);
          }
        case 91: break;
        case 41: 
          { string.append('\"');
          }
        case 92: break;
        case 5: 
          { return symbol(sym.DIVISION);
          }
        case 93: break;
        case 54: 
          { return symbol(sym.WHILE);
          }
        case 94: break;
        case 55: 
          { return symbol(sym.BREAK);
          }
        case 95: break;
        case 27: 
          { return symbol(sym.IF);
          }
        case 96: break;
        case 51: 
          { return symbol(sym.A_READ);
          }
        case 97: break;
        case 46: 
          { return symbol(sym.MODE);
          }
        case 98: break;
        case 37: 
          { return symbol(sym.OR);
          }
        case 99: break;
        case 8: 
          { return symbol(sym.COMA);
          }
        case 100: break;
        case 35: 
          { return symbol(sym.GREATHER_THAN_OR_EQUAL_TO);
          }
        case 101: break;
        case 6: 
          { return symbol(sym.MULTIPLICATION);
          }
        case 102: break;
        case 32: 
          { return symbol(sym.ASSIGNMENT_MODULUS);
          }
        case 103: break;
        case 53: 
          { return symbol(sym.START);
          }
        case 104: break;
        case 44: 
          { return symbol(sym.FOR);
          }
        case 105: break;
        case 52: 
          { return symbol(sym.FLOAT);
          }
        case 106: break;
        case 39: 
          { string.append('\n');
          }
        case 107: break;
        case 26: 
          { return symbol(sym.PIN, yytext());
          }
        case 108: break;
        case 31: 
          { return symbol(sym.ASSIGNMENT_SUBTRACTION);
          }
        case 109: break;
        case 9: 
          { return symbol(sym.SEMI);
          }
        case 110: break;
        case 42: 
          { addLexicalError(INVALID_CHARACTER_ERROR_CODE, yyline+2, UNCLOSED_STRING_MESSAGE, yytext()); return symbol(sym.ERROR);
          }
        case 111: break;
        case 17: 
          { return symbol(sym.ASSIGNMENT);
          }
        case 112: break;
        case 63: 
          { return symbol(sym.ABSTRACT);
          }
        case 113: break;
        case 15: 
          { return symbol(sym.SUBTRACTION);
          }
        case 114: break;
        case 59: 
          { return symbol(sym.D_WRITE);
          }
        case 115: break;
        case 62: 
          { return symbol(sym.BOOLEAN);
          }
        case 116: break;
        case 50: 
          { return symbol(sym.PRINT);
          }
        case 117: break;
        case 16: 
          { return symbol(sym.MODULUS);
          }
        case 118: break;
        case 56: 
          { return symbol(sym.D_READ);
          }
        case 119: break;
        case 14: 
          { return symbol(sym.ADDITION);
          }
        case 120: break;
        case 21: 
          { yybegin(YYINITIAL);
                                   return symbol(sym.STRING_LITERAL,
                                   string.toString());
          }
        case 121: break;
        case 58: 
          { return symbol(sym.STRING);
          }
        case 122: break;
        case 19: 
          { return symbol(sym.LESS_THAN);
          }
        case 123: break;
        case 49: 
          { return symbol(sym.WAIT);
          }
        case 124: break;
        case 20: 
          { string.append( yytext() );
          }
        case 125: break;
        case 60: 
          { return symbol(sym.PROGRAM);
          }
        case 126: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
