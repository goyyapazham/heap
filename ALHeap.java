/*
  Team Top Qual Memes -- Janet Zhang, Nalanda Sharadjaya, Richard Lin
  APCS2 pd5
  hw43 -- Heap of Trouble
  2016-05-23
*/


/*****************************************************
 * class ALHeap
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;

public class ALHeap {

    //instance vars
    private ArrayList<Integer> _heap; //underlying container is array of Integers

    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeap() 
    { 
	_heap=new ArrayList<Integer>();
    }



    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns either 
     * a) a level-order traversal of the tree (simple version)
     * b) ASCII representation of the tree (bit more complicated, much more fun)
     *****************************************************/
    public String toString() 
    { 
	String s="";
	for(int n:_heap)
	    s+=n;
	return s;
    }//O(n)



    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     *****************************************************/
    public boolean isEmpty() 
    { 
	return _heap.isEmpty(); 
    } //O(1)



    /*****************************************************
     * Integer peekMin()
     * Returns min value in heap
     * Postcondition: Heap remains unchanged.
     *****************************************************/
    public Integer peekMin() 
    { 
	return _heap.get(0);
    } //O(1)



    /*****************************************************
     * add(Integer) 
     * Inserts an element in the heap
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public void add( Integer addVal ) 
    { 
        _heap.add(addVal);
	int index=_heap.size()-1;
	if (index==0) return;
	else {
	    if (index%2==0)
		{
		    while (addVal.compareTo(_heap.get((index-2)/2))<0){
			swap(index,(index-2)/2);
			index=((index-2)/2);
		    }
		}
	    else
		{
		    while (addVal.compareTo(_heap.get((index-1)/2))<0){
			swap(index,(index-1)/2);
			index=((index-1)/2);
		    }
		}
	}	
    } //O(n)
    


    /*****************************************************
     * removeMin()  ---  means of removing an element from heap
     * Removes and returns least element in heap.
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public Integer removeMin() 
    {
	//to be returned
	Integer min = _heap.get(0);
	swap(0, _heap.size()-1);
	_heap.remove(_heap.size()-1);

	//the thing you artificially implanted is now at the root
	int i=0;
	//while it has at least one child
	while( 2*i+1<_heap.size() ) {

	    //find the smaller child's index
	    int minInd = minChildPos(i);	   
	        
	    //if it's bigger than its smaller child, swap them
	    if( _heap.get(i) > _heap.get(minInd) ) {
		swap( minInd, i );
		i=minInd;
	    }
	    
	    //otherwise you're done
	    else break;

	}

	//you stored this way back to be returned
	return min;
	    
    }//O(n)



    /*****************************************************
     * minChildPos(int)  ---  helper fxn for removeMin()
     *NOTE: UNUSED SINCE THIS WAS WRITTEN AFTER REMOVEMIN WAS WRITTEN
     * Returns index of least child, or 
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     *****************************************************/
    private int minChildPos( int pos ) 
    {
	int min = 2*pos+2;

	if (pos > _heap.size()) {
	    min = -1;
	}

	else if (2*pos+2 == _heap.size()) {
	    min = 2*pos+1;
	}
	
	else if (2*pos+2 < _heap.size()) {
	    //find out the smaller of its children
	    
	    if( _heap.get(2*pos+1) < _heap.get(2*pos+2) ) {
		min--;
	    }

	}

	else {
	    min = -1;
	}

	return min;
    } //O(1)



    //************ aux helper fxns ***************
    private Integer minOf( Integer a, Integer b ) 
    {
	if ( a.compareTo(b) < 0 )
	    return a;
	else
	    return b;
    }

    //swap for an ArrayList
    private void swap( int pos1, int pos2 ) 
    {
	_heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );	
    }
    //********************************************



    //main method for testing
    public static void main( String[] args ) {


	  ALHeap pile = new ALHeap();

	  pile.add(2);
	  System.out.println(pile);
	  pile.add(4);
	  System.out.println(pile);
	  pile.add(6);
	  System.out.println(pile);
	  pile.add(8);
	  System.out.println(pile);
	  pile.add(10);
	  System.out.println(pile);
	  pile.add(1);
	  System.out.println(pile);
	  pile.add(3);
	  System.out.println(pile);
	  pile.add(5);
	  System.out.println(pile);
	  pile.add(7);
	  System.out.println(pile);
	  pile.add(9);
	  System.out.println(pile);

	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	/*--V--------------MOVE ME DOWN------------------V---

	  ==|============================================|===*/

    }//end main()

}//end class ALHeap
