Implement an iterator to flatten a 2d vector.

For example,
Given 2d vector =

[
  [1,2],
  [3],
  [4,5,6]
]

By calling next repeatedly until hasNext returns false, 
the order of elements returned by next should be: [1,2,3,4,5,6].

How many variables do you need to keep track?
Two variables is all you need. Try with x and y.
Beware of empty rows. It could be the first few rows.
To write correct code, think about the invariant to maintain. What is it?
The invariant is x and y must always point to a valid point in the 2d vector. Should you maintain your invariant ahead of time or right when you need it?
Not sure? Think about how you would implement hasNext(). Which is more complex?
Common logic in two different places should be refactored into a common method.

class Vector2D {
	private Iterator<List<Integer>> row = null;
    private Iterator<Integer> col = null;

    
    public Vector2D(List<List<Integer>> vec2d) {
        row = vec2d.iterator();
        if(row.hasNext())
            col = row.next().iterator();
    }

    public int next() {
        int lastValue = col.next();
        return lastValue;
    }

    public boolean hasNext() {
        if(col == null) {
            return false;
        }
        if(col.hasNext()) {
            return true;
        } else {
            while(row.hasNext()) {
                col = row.next().iterator();
                if(col.hasNext())
                    return true;
            }
            return false;
        }
    }
    
    
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */