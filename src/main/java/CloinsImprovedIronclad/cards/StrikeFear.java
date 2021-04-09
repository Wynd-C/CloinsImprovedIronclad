package CloinsImprovedIronclad.cards;

import basemod.AutoAdd;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import CloinsImprovedIronclad.DefaultMod;
import CloinsImprovedIronclad.characters.TheDefault;
import com.megacrit.cardcrawl.powers.WeakPower;

import static CloinsImprovedIronclad.DefaultMod.makeCardPath;


public class StrikeFear extends AbstractDynamicCard {


    // TEXT DECLARATION

    public static final String ID = DefaultMod.makeID(StrikeFear.class.getSimpleName()); // USE THIS ONE FOR THE TEMPLATE;
    public static final String IMG = makeCardPath("Skill.png");// "public static final String IMG = makeCardPath("StrikeFear.png");


    // /TEXT DECLARATION/


    // STAT DECLARATION

    private static final CardRarity RARITY = CardRarity.UNCOMMON; //  Up to you, I like auto-complete on these
    private static final CardTarget TARGET = CardTarget.ENEMY;  //   since they don't change much.
    private static final CardType TYPE = CardType.SKILL;       //
    public static final CardColor COLOR = CardColor.RED;

    private static final int COST = 1;  // COST = 1
    private static final int UPGRADED_COST = 0; // UPGRADED_COST = 1

    private static final int MAGICNUMBER = 1;
    private static final int UPGRADE_PLUS_MAGICNUMBER = 1;
    private static final int SECONDMAGICNUMBER = 3;


    // /STAT DECLARATION/


    public StrikeFear() { // public StrikeFear() - This one and the one right under the imports are the most important ones, don't forget them
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        baseMagicNumber = MAGICNUMBER;
        magicNumber = baseMagicNumber;
        defaultBaseSecondMagicNumber = SECONDMAGICNUMBER;
        defaultSecondMagicNumber = defaultBaseSecondMagicNumber;
        this.exhaust = true;
        this.tags.add(CardTags.STRIKE);
    }


    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        for (int i =0; i < defaultSecondMagicNumber; i++){
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(m, p, new WeakPower(m, this.magicNumber, false), this.magicNumber));
        }

    }


    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeMagicNumber(UPGRADE_PLUS_MAGICNUMBER);
            upgradeBaseCost(UPGRADED_COST);
            initializeDescription();
        }
    }
}
