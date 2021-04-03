package CloinsImprovedIronclad.cards;

import basemod.AutoAdd;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import CloinsImprovedIronclad.DefaultMod;
import CloinsImprovedIronclad.characters.TheDefault;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.powers.ArtifactPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;
import com.megacrit.cardcrawl.powers.watcher.MarkPower;

import static CloinsImprovedIronclad.DefaultMod.makeCardPath;

// public class ${NAME} extends AbstractDynamicCard
public class Versatility extends AbstractDynamicCard {

    // TEXT DECLARATION

    public static final String ID = DefaultMod.makeID(Versatility.class.getSimpleName()); // USE THIS ONE FOR THE TEMPLATE;
    public static final String IMG = makeCardPath("Attack.png");// "public static final String IMG = makeCardPath("${NAME}.png");


    // /TEXT DECLARATION/


    // STAT DECLARATION

    private static final CardRarity RARITY = CardRarity.UNCOMMON; //  Up to you, I like auto-complete on these
    private static final CardTarget TARGET = CardTarget.SELF;  //   since they don't change much.
    private static final CardType TYPE = CardType.SKILL;       //
    public static final CardColor COLOR = CardColor.COLORLESS;

    private static final int COST = 1;  // COST = ${COST}
    private static final int UPGRADED_COST = 0; // UPGRADED_COST = ${UPGRADED_COST}

    private static final int DAMAGE = 5;
    private static final int UPGRADE_PLUS_DMG = 2;

    private static final int MAGIC_NUMBER = 3;
    // /STAT DECLARATION/


    public Versatility() { // public ${NAME}() - This one and the one right under the imports are the most important ones, don't forget them
        super(ID, IMG, COST, TYPE, COLOR, RARITY, TARGET);
        baseDamage = DAMAGE;
        magicNumber = MAGIC_NUMBER;
        baseMagicNumber = magicNumber;
        this.showEvokeValue = true;
        this.showEvokeOrbCount = 1;
    }


    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(
                new DamageAction(m, new DamageInfo(p, damage, damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
        if (AbstractDungeon.player.chosenClass == AbstractPlayer.PlayerClass.WATCHER) {
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(m, p, new MarkPower(m, 5), 5));
        }
        else if (AbstractDungeon.player.chosenClass == AbstractPlayer.PlayerClass.DEFECT) {
                            AbstractDungeon.actionManager.addToBottom(new ChannelAction(AbstractOrb.getRandomOrb(true)));
        }
        else if (AbstractDungeon.player.chosenClass == AbstractPlayer.PlayerClass.THE_SILENT) {
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(m, p, new WeakPower(m, this.magicNumber, false ), this.magicNumber));
        }
        else {
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(m, p, new VulnerablePower(m, this.magicNumber, false), this.magicNumber));
        }
    }

    // Upgraded stats.
    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeDamage(UPGRADE_PLUS_DMG);
            upgradeBaseCost(UPGRADED_COST);
            initializeDescription();
        }
    }
}
