interface Movable {
    int getX();
    int getY();
    void setX(int newX);
    void setY(int newY);
}

interface Storable {
    int getInventoryLength();
    String getInventoryItem(int index);
    void setInventoryItem(int index, String item);
}

interface Command {
    void execute();
    void undo();
}

class CommandMove implements Command {
    Movable entity;
    int xMovement;
    int yMovement;

    @Override
    public void execute() {
        this.entity.setX(this.entity.getX() + xMovement);
        this.entity.setY(this.entity.getY() + yMovement);
    }

    @Override
    public void undo() {
        this.entity.setX(this.entity.getX() - xMovement);
        this.entity.setY(this.entity.getY() - yMovement);
    }
}

class CommandPutItem implements Command {
    Storable entity;
    String item;
    int index;

    @Override
    public void execute() {
        for (int i = 0; i < this.entity.getInventoryLength(); i++) {
            if (this.entity.getInventoryItem(i) == null) {
                this.entity.setInventoryItem(i, this.item);
                this.index = i;
                break;
            }
        }
    }

    @Override
    public void undo() {
        this.entity.setInventoryItem(this.index, null);
    }
}