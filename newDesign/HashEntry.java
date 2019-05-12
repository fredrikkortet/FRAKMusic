public class HashEntry<Anytype> {
    public Object element; // the element
    public boolean isActive; // false if marked deleted

    public HashEntry(Object e) {
        this(e, true);
    }

    public HashEntry(Object e, boolean i) {
        element = e;
        isActive = i;
    }
    public Object getelement(){
        return element;
    }
}