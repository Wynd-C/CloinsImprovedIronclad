package CloinsImprovedIronclad.cards;

import CloinsImprovedIronclad.actions.ParryAndRiposteAction;
import basemod.AutoAdd;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import CloinsImprovedIronclad.DefaultMod;
import CloinsImprovedIronclad.characters.TheDefault;

import static CloinsImprovedIronclad.DefaultMod.makeCardPath;

// public class Parry and Riposte extends AbstractDynamicCard
public class ParryAndRiposte extends AbstractDynamicCard {



    // TEXT DECLARATION

    // public static final String ID = DefaultMod.makeID(Parry and Riposte.class.getSimpleName()); // USE THIS ONE FOR THE TEMPLATE;
    public static final String ID = DefaultMod.makeID("DefaultCommonAttack"); // DELETE THIS ONE.
    public static final String IMG = makeCardPath("Attack.png");// "public static final String IMG = makeCardPath("Parry and Riposte.png");
    // This does mean that you will need to have an image with the same NAME as the card in your image folder for it to run correctly.


    // /TEXT DECLARATION/


    // STAT DECLARATION

    private static final CardRarity RARITY = CardRarity.RARE; //  Up to you, I like auto-complete on these
    private static final CardTarget TARGET = CardTarget.ENEMY;  //   since they don't change much.
    private static final CardType TYPE = CardType.ATTACK;       //
    public static final CardColor COLOR = TheDefault.Enums.COLOR_GRAY;

    private static final int COST = 1;  // COST = 1

    private static final int DAMAGE = 5;

    private static final int MAGICNUMBER = 3;

    // /STAT DECLARATION/


    public ParryAndRiposte() {
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        baseDamage = DAMAGE;
        baseMagicNumber = MAGICNUMBER;
        this.exhaust = true;
    }


    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn)));
        AbstractDungeon.actionManager.addToBottom(new ParryAndRiposteAction(this.baseMagicNumber, m));
    }


    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            this.exhaust = false;
            initializeDescription();
        }
    }
}
