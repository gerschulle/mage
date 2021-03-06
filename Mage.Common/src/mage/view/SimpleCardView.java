/*
* Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
*
* Redistribution and use in source and binary forms, with or without modification, are
* permitted provided that the following conditions are met:
*
*    1. Redistributions of source code must retain the above copyright notice, this list of
*       conditions and the following disclaimer.
*
*    2. Redistributions in binary form must reproduce the above copyright notice, this list
*       of conditions and the following disclaimer in the documentation and/or other materials
*       provided with the distribution.
*
* THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
* WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
* FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
* CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
* CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
* SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
* ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
* NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
* ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*
* The views and conclusions contained in the software and documentation are those of the
* authors and should not be interpreted as representing official policies, either expressed
* or implied, of BetaSteward_at_googlemail.com.
*/

package mage.view;

import java.io.Serializable;
import java.util.UUID;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class SimpleCardView implements Serializable {
    protected UUID id;
    protected String expansionSetCode;
    protected String tokenSetCode;
    protected int cardNumber;
    protected boolean usesVariousArt;
    protected boolean gameObject;

    public SimpleCardView(UUID id, String expansionSetCode, int cardNumber, boolean usesVariousArt, String tokenSetCode) {
        this(id, expansionSetCode, cardNumber, usesVariousArt, tokenSetCode, false);
    }
    public SimpleCardView(UUID id, String expansionSetCode, int cardNumber, boolean usesVariousArt, String tokenSetCode, boolean isGameObject) {
        this.id = id;
        this.expansionSetCode = expansionSetCode;
        this.cardNumber = cardNumber;
        this.usesVariousArt = usesVariousArt;
        this.tokenSetCode = tokenSetCode;
        this.gameObject = isGameObject;
    }

    public UUID getId() {
        return id;
    }

    public String getExpansionSetCode() {
        return expansionSetCode;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public boolean getUsesVariousArt() {
        return usesVariousArt;
    }

    public String getTokenSetCode() {
        return tokenSetCode;
    }

    public boolean isGameObject() {
        return gameObject;
    }    
}
