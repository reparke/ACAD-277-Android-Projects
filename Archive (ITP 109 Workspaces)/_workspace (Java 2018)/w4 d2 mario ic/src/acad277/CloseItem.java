package acad277;

public class CloseItem extends Item {
    private boolean isThrowable;

    public CloseItem(String itemName, String itemColor, int itemDamage, boolean isThrowable) {
        super(itemName, itemColor, itemDamage);
        this.isThrowable = isThrowable;
    }

    @Override
    public String toString() {
        return "CloseItem{" +
                "isThrowable=" + isThrowable +
                '}';
    }

    public boolean isThrowable() {
        return isThrowable;
    }

    public void setThrowable(boolean throwable) {
        isThrowable = throwable;
    }

    public void use() {
        System.out.println("Using " + getName());
    }

    public void throwItem() {
        if (isThrowable == true) {
            System.out.println("Throwing " + getName());
        }
        else {
            System.out.println("Can't throw " + getName());
        }
    }
}










