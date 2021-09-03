abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        //return tick or X symbols
        return "[" +(isDone ? "\u2713" : "\u2718")+"]" ;
    }

    public String markAsDone() {
        this.isDone = true;
        //return tick or X symbols
        return (getStatusIcon());
    }

    @Override
    public String toString(){
        return getStatusIcon() + " " + this.description;
    }
}