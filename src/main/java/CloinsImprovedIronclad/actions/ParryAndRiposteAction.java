package CloinsImprovedIronclad.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PlatedArmorPower;
import CloinsImprovedIronclad.DefaultMod;
import CloinsImprovedIronclad.characters.TheDefault;

public class ParryAndRiposteAction extends AbstractGameAction {
    private AbstractMonster m;

    public ParryAndRiposteAction(int plateAmt, AbstractMonster m) {
        this.actionType = ActionType.WAIT;
        this.amount = plateAmt;
        this.m = m;
    }

    public void update() {
        if (this.m != null && this.m.getIntentBaseDmg() >= 0) {
            this.addToTop(new ApplyPowerAction(this.m, AbstractDungeon.player, new PlatedArmorPower(this.m, this.amount), this.amount));
        }

        this.isDone = true;
    }
}
