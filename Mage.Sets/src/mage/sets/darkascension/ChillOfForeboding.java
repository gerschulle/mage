/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */
package mage.sets.darkascension;

import java.util.UUID;

import mage.constants.CardType;
import mage.constants.Outcome;
import mage.constants.Rarity;
import mage.constants.Zone;
import mage.abilities.Ability;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.OneShotEffect;
import mage.abilities.keyword.FlashbackAbility;
import mage.cards.Card;
import mage.cards.CardImpl;
import mage.constants.TimingRule;
import mage.game.Game;
import mage.players.Player;

/**
 *
 * @author North
 */
public class ChillOfForeboding extends CardImpl {

    public ChillOfForeboding(UUID ownerId) {
        super(ownerId, 32, "Chill of Foreboding", Rarity.UNCOMMON, new CardType[]{CardType.SORCERY}, "{2}{U}");
        this.expansionSetCode = "DKA";

        // Each player puts the top five cards of his or her library into his or her graveyard.
        this.getSpellAbility().addEffect(new ChillOfForebodingEffect());
        // Flashback {7}{U}
        this.addAbility(new FlashbackAbility(new ManaCostsImpl("{7}{U}"), TimingRule.SORCERY));
    }

    public ChillOfForeboding(final ChillOfForeboding card) {
        super(card);
    }

    @Override
    public ChillOfForeboding copy() {
        return new ChillOfForeboding(this);
    }
}

class ChillOfForebodingEffect extends OneShotEffect {

    public ChillOfForebodingEffect() {
        super(Outcome.Detriment);
        this.staticText = "Each player puts the top five cards of his or her library into his or her graveyard";
    }

    public ChillOfForebodingEffect(final ChillOfForebodingEffect effect) {
        super(effect);
    }

    @Override
    public ChillOfForebodingEffect copy() {
        return new ChillOfForebodingEffect(this);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Player sourcePlayer = game.getPlayer(source.getControllerId());
        for (UUID playerId : sourcePlayer.getInRange()) {
            Player player = game.getPlayer(playerId);
            if (player != null) {
                player.moveCards(player.getLibrary().getTopCards(game, 5), Zone.LIBRARY, Zone.GRAVEYARD, source, game);
            }
        }
        return true;
    }
}
