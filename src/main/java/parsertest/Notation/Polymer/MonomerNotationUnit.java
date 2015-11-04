/**
 * *****************************************************************************
 * Copyright C 2015, The Pistoia Alliance
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *****************************************************************************
 */
package parsertest.Notation.Polymer;


/**
 * MonomerNotationUnit
 * 
 * @author hecht
 */
public final class MonomerNotationUnit extends MonomerNotation {

  /**
   * Constructs with the given String
   * 
   * @param str Monomer
   */
  public MonomerNotationUnit(String str) {
    super(str);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toHELM2() {

    String text = unit;
    if (isDefault == false) {
      if (unit.length() > 1) {
        text = "(" + unit + ")";
      }
      text += "'" + count + "'";
    }

    if (isAnnotationHere) {
      text += "\"" + annotation + "\"";
    }
    return text;
  }


}