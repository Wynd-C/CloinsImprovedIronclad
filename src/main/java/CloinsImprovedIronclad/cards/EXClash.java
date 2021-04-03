package CloinsImprovedIronclad.cards;

import basemod.AutoAdd;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.cards.AbstractCard;
import java.util.Iterator;
import CloinsImprovedIronclad.DefaultMod;
import CloinsImprovedIronclad.characters.TheDefault;
import java.util.List;
import java.util.function.Predicate;


import static CloinsImprovedIronclad.DefaultMod.makeCardPath;

@AutoAdd.Ignore
public class EXClash extends AbstractDynamicCard {


    public static final String ID = DefaultMod.makeID(EXClash.class.getSimpleName()); // USE THIS ONE FOR THE TEMPLATE;
    public static final String IMG = makeCardPath("Attack.png");// "public static final String IMG = makeCardPath("${NAME}.png");

    // /TEXT DECLARATION/


    // STAT DECLARATION

    private static final CardRarity RARITY = CardRarity.COMMON; //  Up to you, I like auto-complete on these
    private static final CardTarget TARGET = CardTarget.ENEMY;  //   since they don't change much.
    private static final CardType TYPE = CardType.ATTACK;       //
    public static final CardColor COLOR = CardColor.RED;

    private static final int COST = 0;  // COST = ${COST}

    private static final int DAMAGE = 14;    // DAMAGE = ${DAMAGE}
    private static final int UPGRADE_PLUS_DMG = 4;  // UPGRADE_PLUS_DMG = ${UPGRADED_DAMAGE_INCREASE}

    private static final int WEAK_DAMAGE = 4;

    // /STAT DECLARATION/


    public EXClash() { // public ${NAME}() - This one and the one right under the imports are the most important ones, don't forget them
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        baseDamage = DAMAGE;
    }


    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        for (AbstractCard c : AbstractDungeon.player.hand.group) {
            if (c.type != CardType.ATTACK){
                AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p, this.WEAK_DAMAGE, this.damageTypeForTurn)));
                return;
            }
        }
        AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p, this.baseDamage, this.damageTypeForTurn)));
    }


    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeDamage(UPGRADE_PLUS_DMG);
            initializeDescription();
        }
    }
}