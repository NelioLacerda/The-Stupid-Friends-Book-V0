package ex;
/**
 * @author Lord_Gargamelster
 */
public class Publication {
    private Action action;

    public Publication(String actionName){
        this.setAction(actionName);
    }

    public Action getAction() {
        return action;
    }

    private void setAction(String actionName) {
        this.action = new Action(actionName);
    }
}
