/* The following code was generated by JFlex 1.4.3 on 2/8/22 12:30 AM */

/* JFlex example: partial Java language lexer specification */

package com.deimos.compilador.services.paint;

import com.deimos.compilador.model.painter.PaintRequest;
import com.deimos.compilador.utils.EditorColors;
import java.awt.Color;
import java.util.List;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 2/8/22 12:30 AM from the specification file
 * <tt>C:/Users/arcin/Documents/NetBeansProjects/compilador/src/main/java/com/deimos/compilador/services/paint/LexerPainter.flex</tt>
 */
class LexerPainter {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = {
     0,  0,  0,  0,  0,  0,  0,  0,  0,  5,  4,  0,  5,  3,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
    48, 46, 39,  0,  0, 44, 47,  0, 41, 41,  7, 42, 41, 43,  0,  6, 
     9,  2,  2,  2,  2,  2,  2,  2,  2,  2,  0, 40, 44, 45, 44,  0, 
     0,  8,  8,  8,  8,  8,  8, 30, 28, 29,  8,  8, 31,  8,  8, 24, 
    27,  8, 18,  8, 26, 25,  8, 23,  8,  8,  8,  0,  0,  0,  0,  1, 
     0, 15, 36, 37, 19, 13, 33, 32, 35, 10,  1, 38, 34, 21, 11, 22, 
    20,  1, 14, 16, 12,  1,  1, 17,  1,  1,  1, 41, 49, 41,  0,  0, 
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
    "\1\0\1\1\1\2\1\3\2\4\3\2\1\3\15\2"+
    "\1\5\1\6\3\2\3\1\1\7\1\0\1\3\1\1"+
    "\2\2\1\10\20\2\1\0\1\5\1\0\2\7\2\0"+
    "\22\2\1\0\1\7\1\11\5\2\1\12\17\2";

  private static int [] zzUnpackAction() {
    int [] result = new int[103];
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
    "\0\0\0\62\0\144\0\226\0\310\0\62\0\372\0\u012c"+
    "\0\u015e\0\u0190\0\u01c2\0\u01f4\0\u0226\0\u0258\0\u028a\0\u02bc"+
    "\0\u02ee\0\u0320\0\u0352\0\u0384\0\u03b6\0\u03e8\0\u041a\0\u044c"+
    "\0\62\0\62\0\u047e\0\u04b0\0\u012c\0\u04e2\0\u0514\0\u0546"+
    "\0\u0578\0\144\0\u0190\0\u05aa\0\u05dc\0\144\0\u060e\0\u0640"+
    "\0\u0672\0\u06a4\0\u06d6\0\u0708\0\u073a\0\u076c\0\u079e\0\u07d0"+
    "\0\u0802\0\u0834\0\u0866\0\u0898\0\u08ca\0\u08fc\0\u044c\0\62"+
    "\0\u092e\0\u0960\0\62\0\u0992\0\u09c4\0\u09f6\0\u0a28\0\u0a5a"+
    "\0\u0a8c\0\u0abe\0\u0af0\0\u0b22\0\u0b54\0\u0b86\0\u0bb8\0\u0bea"+
    "\0\u0c1c\0\u0c4e\0\u0c80\0\u0cb2\0\u0ce4\0\u0d16\0\u0d48\0\u0d7a"+
    "\0\u0992\0\144\0\u0dac\0\u0dde\0\u0e10\0\u0e42\0\u0e74\0\144"+
    "\0\u0ea6\0\u0ed8\0\u0f0a\0\u0f3c\0\u0f6e\0\u0fa0\0\u0fd2\0\u1004"+
    "\0\u1036\0\u1068\0\u109a\0\u10cc\0\u10fe\0\u1130\0\u1162";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[103];
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
    "\1\2\1\3\1\4\1\5\2\6\1\7\1\10\1\11"+
    "\1\12\1\13\2\3\1\14\1\3\1\15\1\16\1\17"+
    "\1\11\1\20\1\21\1\22\1\3\1\11\1\23\3\11"+
    "\1\24\2\11\1\25\1\3\1\26\2\3\1\27\2\3"+
    "\1\30\1\31\1\32\1\33\1\34\2\10\1\35\1\36"+
    "\1\6\1\37\63\0\2\3\5\0\37\3\15\0\1\4"+
    "\6\0\1\4\54\0\1\6\63\0\1\40\1\41\45\0"+
    "\1\32\61\0\1\32\5\0\1\3\1\42\5\0\1\3"+
    "\1\42\35\3\15\0\1\43\6\0\1\43\51\0\2\3"+
    "\5\0\3\3\1\44\1\45\24\3\1\46\5\3\14\0"+
    "\2\3\5\0\32\3\1\47\4\3\14\0\2\3\5\0"+
    "\12\3\1\50\4\3\1\51\14\3\1\52\2\3\14\0"+
    "\2\3\5\0\4\3\1\53\32\3\14\0\2\3\5\0"+
    "\7\3\1\54\23\3\1\55\3\3\14\0\2\3\5\0"+
    "\12\3\1\50\4\3\1\51\17\3\14\0\2\3\5\0"+
    "\6\3\1\56\30\3\14\0\2\3\5\0\16\3\1\57"+
    "\20\3\14\0\1\3\1\42\5\0\1\3\1\42\17\3"+
    "\1\60\15\3\14\0\1\3\1\42\5\0\1\3\1\42"+
    "\23\3\1\61\11\3\14\0\1\3\1\42\5\0\1\3"+
    "\1\42\16\3\1\62\16\3\14\0\2\3\5\0\16\3"+
    "\1\63\13\3\1\64\4\3\14\0\2\3\5\0\6\3"+
    "\1\65\7\3\1\66\20\3\13\0\4\67\1\0\42\67"+
    "\1\70\12\67\52\0\1\32\2\0\1\32\57\0\1\32"+
    "\1\0\1\32\63\0\1\71\63\0\1\32\3\40\1\72"+
    "\1\73\55\40\7\74\1\75\52\74\1\0\2\3\5\0"+
    "\2\3\1\76\1\3\1\46\32\3\14\0\2\3\5\0"+
    "\5\3\1\77\31\3\14\0\2\3\5\0\10\3\1\100"+
    "\26\3\14\0\2\3\5\0\5\3\1\101\31\3\14\0"+
    "\2\3\5\0\6\3\1\102\30\3\14\0\2\3\5\0"+
    "\10\3\1\103\26\3\14\0\2\3\5\0\6\3\1\104"+
    "\1\105\27\3\14\0\2\3\5\0\2\3\1\106\34\3"+
    "\14\0\2\3\5\0\2\3\1\107\34\3\14\0\2\3"+
    "\5\0\2\3\1\110\13\3\1\111\20\3\14\0\2\3"+
    "\5\0\13\3\1\112\23\3\14\0\2\3\5\0\22\3"+
    "\1\113\14\3\14\0\2\3\5\0\26\3\1\114\10\3"+
    "\14\0\2\3\5\0\17\3\1\42\17\3\14\0\2\3"+
    "\5\0\6\3\1\46\30\3\14\0\2\3\5\0\16\3"+
    "\1\115\20\3\14\0\2\3\5\0\5\3\1\116\31\3"+
    "\14\0\2\3\5\0\16\3\1\117\20\3\73\0\1\32"+
    "\5\0\1\73\55\0\7\74\1\120\60\74\1\121\1\120"+
    "\52\74\1\0\2\3\5\0\4\3\1\122\32\3\14\0"+
    "\2\3\5\0\6\3\1\123\30\3\14\0\2\3\5\0"+
    "\5\3\1\46\31\3\14\0\2\3\5\0\7\3\1\124"+
    "\27\3\14\0\2\3\5\0\2\3\1\125\34\3\14\0"+
    "\2\3\5\0\4\3\1\126\32\3\14\0\2\3\5\0"+
    "\2\3\1\127\34\3\14\0\2\3\5\0\6\3\1\106"+
    "\30\3\14\0\2\3\5\0\4\3\1\130\32\3\14\0"+
    "\2\3\5\0\32\3\1\100\4\3\14\0\2\3\5\0"+
    "\3\3\1\106\33\3\14\0\2\3\5\0\30\3\1\131"+
    "\6\3\14\0\2\3\5\0\5\3\1\130\31\3\14\0"+
    "\2\3\5\0\23\3\1\132\13\3\14\0\2\3\5\0"+
    "\24\3\1\42\12\3\14\0\2\3\5\0\7\3\1\133"+
    "\27\3\14\0\2\3\5\0\7\3\1\134\27\3\14\0"+
    "\2\3\5\0\32\3\1\135\4\3\13\0\6\74\1\73"+
    "\1\120\52\74\1\0\2\3\5\0\7\3\1\136\27\3"+
    "\14\0\2\3\5\0\13\3\1\130\23\3\14\0\2\3"+
    "\5\0\4\3\1\112\32\3\14\0\2\3\5\0\6\3"+
    "\1\137\30\3\14\0\2\3\5\0\3\3\1\140\33\3"+
    "\14\0\2\3\5\0\6\3\1\141\30\3\14\0\2\3"+
    "\5\0\21\3\1\142\15\3\14\0\2\3\5\0\4\3"+
    "\1\46\32\3\14\0\2\3\5\0\36\3\1\46\14\0"+
    "\2\3\5\0\5\3\1\143\31\3\14\0\2\3\5\0"+
    "\4\3\1\144\32\3\14\0\2\3\5\0\7\3\1\145"+
    "\27\3\14\0\2\3\5\0\30\3\1\46\6\3\14\0"+
    "\2\3\5\0\7\3\1\146\27\3\14\0\2\3\5\0"+
    "\22\3\1\42\14\3\14\0\2\3\5\0\7\3\1\147"+
    "\27\3\14\0\2\3\5\0\5\3\1\122\31\3\14\0"+
    "\2\3\5\0\35\3\1\133\1\3\14\0\2\3\5\0"+
    "\15\3\1\46\21\3\14\0\2\3\5\0\3\3\1\46"+
    "\33\3\13\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4500];
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
    "\1\0\1\11\3\1\1\11\22\1\2\11\6\1\1\0"+
    "\25\1\1\0\1\11\1\0\1\1\1\11\2\0\22\1"+
    "\1\0\27\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[103];
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
  private void addPaintRequest(int posIni, int posFin, Color color){
    List<PaintRequest> paintRequests = PaintService.paintRequestList.getPaintRequests();
    PaintRequest paintRequest = new PaintRequest(posIni, posFin, color);
    paintRequests.add(paintRequest);
  }


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  LexerPainter(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  LexerPainter(java.io.InputStream in) {
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
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Tokens yylex() throws java.io.IOException {
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
        case 10: 
          { addPaintRequest(yychar, yylength(), EditorColors.FUNCTIONS);
          }
        case 11: break;
        case 9: 
          { addPaintRequest(yychar, yylength(), EditorColors.METHODS);
          }
        case 12: break;
        case 1: 
          { addPaintRequest(yychar, yylength(), EditorColors.ERROR);
          }
        case 13: break;
        case 2: 
          { addPaintRequest(yychar, yylength(), EditorColors.DEFAULT);
          }
        case 14: break;
        case 7: 
          { addPaintRequest(yychar, yylength(), EditorColors.COMMENTS);
          }
        case 15: break;
        case 3: 
          { addPaintRequest(yychar, yylength(), EditorColors.NUMBERS);
          }
        case 16: break;
        case 5: 
          { addPaintRequest(yychar, yylength(), EditorColors.STRING);
          }
        case 17: break;
        case 4: 
          { /* ignore */
          }
        case 18: break;
        case 8: 
          { addPaintRequest(yychar, yylength(), EditorColors.KEYWORDS);
          }
        case 19: break;
        case 6: 
          { addPaintRequest(yychar, yylength(), EditorColors.SEMICOLON);
          }
        case 20: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return null;
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
