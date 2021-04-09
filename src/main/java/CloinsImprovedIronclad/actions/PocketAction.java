package CloinsImprovedIronclad.actions;

import CloinsImprovedIronclad.cards.AbstractDynamicCard;
import CloinsImprovedIronclad.cards.Pocket;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.unique.GreedAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.AbstractCard.CardColor;
import com.megacrit.cardcrawl.cards.AbstractCard.CardRarity;
import com.megacrit.cardcrawl.cards.AbstractCard.CardTarget;
import com.megacrit.cardcrawl.cards.AbstractCard.CardType;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.GainPennyEffect;

public class PocketAction extends AbstractGameAction {
    private int increaseGold;
    private static final float DURATION = 0.1F;
    private AbstractMonster targetMonster;

    public PocketAction(int increaseGold, AbstractMonster m){
        this.duration = DURATION;
        this.actionType = ActionType.WAIT;
        this.increaseGold = increaseGold;
        this.targetMonster = m;
    }
    public void update(){
        if (this.targetMonster != null && this.targetMonster.getIntentBaseDmg() >= 0){
            AbstractDungeon.player.gainGold(this.increaseGold);

            for(int i = 0; i < this.increaseGold; ++i) {
                AbstractDungeon.effectList.add(new GainPennyEffect(this.source, this.target.hb.cX, this.target.hb.cY, this.source.hb.cX, this.source.hb.cY, true));

            }
        }
        this.isDone = true;
    }
}