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
package parsertest.ConnectionSection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import parsertest.State;
import parsertest.StateMachineParser;
import parsertest.ExceptionParser.ConnectionSectionException;
import parsertest.GroupingSection.GroupingParser;

/**
 * BetweenInlineConnectionParser class to represent the transition state between the inline annotation and all possible
 * states in the connection parser
 * 
 * @author hecht
 */
public class BetweenInlineConnectionParser implements State {

  private StateMachineParser _parser;

  private static final Logger logger = LoggerFactory.getLogger(BetweenInlineConnectionParser.class);

  /**
   * Constructs with the state machine parser
   * 
   * @param pParser
   */
  public BetweenInlineConnectionParser(StateMachineParser pParser) {
    _parser = pParser;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void doAction(Character cha) throws ConnectionSectionException {
    /* new connection is starting */
    if (cha == '|') {
      logger.info("A new Connection is starting:");
      _parser.setState(new ConnectionsParser(_parser));
    }

    /* grouping section is starting */
    else if (cha == '$') {
      logger.info("Transition to group Section");
      logger.info("Group section is starting:");
      _parser.setState(new GroupingParser(_parser));
    }

    /* invalid character */
    else {
      logger.error("Invalid character after inline annotation in connection section: " + cha);
      throw new ConnectionSectionException("Invalid character after inline annotation in connection section: " + cha);
    }

  }

}