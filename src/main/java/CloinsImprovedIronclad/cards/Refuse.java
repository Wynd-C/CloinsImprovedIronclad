package CloinsImprovedIronclad.cards;

import basemod.AutoAdd;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import CloinsImprovedIronclad.DefaultMod;
import CloinsImprovedIronclad.characters.TheDefault;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.powers.NoxiousFumesPower;


import static CloinsImprovedIronclad.DefaultMod.makeCardPath;


public class Refuse extends AbstractDynamicCard {

    // TEXT DECLARATION

    public static final String ID = DefaultMod.makeID(Refuse.class.getSimpleName()); // USE THIS ONE FOR THE TEMPLATE;
    public static final String IMG = makeCardPath("Refuse.png");// "public static final String IMG = makeCardPath("${NAME}.png");

    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

    // /TEXT DECLARATION/


    // STAT DECLARATION

    private static final CardRarity RARITY = CardRarity.UNCOMMON; //  Up to you, I like auto-complete on these
    private static final CardTarget TARGET = CardTarget.NONE;  //   since they don't change much.
    private static final CardType TYPE = CardType.SKILL;
    public static final CardColor COLOR = CardColor.GREEN;

    private static final int COST = -2;  // COST = ${COST}

    private static final int MAGICNUMBER = 4;
    private static final int UPGRADE_PLUS_MAGIC_NUMBER = 2;

    // /STAT DECLARATION/


    public Refuse() { // public ${NAME}() - This one and the one right under the imports are the most important ones, don't forget them
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        baseMagicNumber = MAGICNUMBER;
        magicNumber = baseMagicNumber;
    }


    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
    }

    public boolean canUse(AbstractPlayer p, AbstractMonster m){
        return false;
    }

    public void triggerOnManualDiscard() {
        calculateCardDamage(null);
       AbstractDungeon.actionManager.addToBottom(
               new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new NoxiousFumesPower(
                       AbstractDungeon.player, magicNumber), magicNumber));
    }

    public AbstractCard makeCopy() {return new Refuse(); }


    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeMagicNumber(UPGRADE_PLUS_MAGIC_NUMBER);
            initializeDescription();
        }
    }
}
