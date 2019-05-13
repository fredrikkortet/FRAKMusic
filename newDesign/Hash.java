
public class Hash<PlayerItem>{
    private static final int defaultSize = 53;
    private HashEntry[] array;
    private int currentSize = 0;
    private int stockInSize = 0;

    public Hash(){
        array = new HashEntry[defaultSize];
    }
    public int size(){
        return currentSize;
    }
    public PlayerItem findMatch(String x){
        int currentPos = findPos(x);

        if(isActive(array, currentPos)){
            return (PlayerItem) array[currentPos];
        }
        return null;
    }
    public boolean anythingthere(Object x){
        return isActive(array, findPos(x));
    }
    private static boolean isActive(HashEntry[]arr, int pos){
        return arr[pos] != null && arr[pos].isActive;
    }
    public PlayerItem add(PlayerItem value){
        int currentPos = findPos(value);
        if(isActive(array, currentPos)){
            return null;
        }
        if(array[currentPos]==null){
            stockInSize++;
        }
            array[currentPos] = new HashEntry(value,true);
            currentSize++;

        if (stockInSize > array.length/2){
            rehash();
        }
        return value;
         
        
    }
    private void rehash() {
        HashEntry[] oldarray = array;

        array = new HashEntry[nextPrime(4*size())];
        currentSize = 0;
        stockInSize = 0;
        
        for(int i=0;i<oldarray.length;i++){
            if(isActive(oldarray,i)){
                add((PlayerItem) oldarray[i].element);
            }
        }
    }
    public boolean remove(Object x) {
        int currentPos = findPos(x);
        if (!isActive(array, currentPos))
            return false;

        array[currentPos].isActive = false;
        currentSize--;

        if (currentSize < array.length / 8)
            rehash();

        return true;
    }
    private int findPos(Object x) {
        int offset = 1;
        int currentPos = (x == null) ? 0 : Math.abs(x.hashCode() % array.length);

        while (array[currentPos] != null) {
            if (x == null) {
                if (array[currentPos].element == null)
                    break;
            } else if (x.equals(array[currentPos].element))
                break;

            currentPos += offset; // Compute ith probe
            offset += 2;
            if (currentPos >= array.length) // Implement the mod
                currentPos -= array.length;
        }

        return currentPos;
    }

    /**
     * Internal method to find a prime number at least as large as n.
     * 
     * @param n the starting number (must be positive).
     * @return a prime number larger than or equal to n.
     */
    private static int nextPrime(int n) {
        if (n % 2 == 0)
            n++;

        for (; !isPrime(n); n += 2)
            ;

        return n;
    }

    /**
     * Internal method to test if a number is prime. Not an efficient algorithm.
     * 
     * @param n the number to test.
     * @return the result of the test.
     */
    private static boolean isPrime(int n) {
        if (n == 2 || n == 3)
            return true;

        if (n == 1 || n % 2 == 0)
            return false;

        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;

        return true;
    }


}