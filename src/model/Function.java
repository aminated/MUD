package model;
import java.util.LinkedList;
import java.util.List;
/**
 * This library introduces first class functions to Java.  
 * @author Andrey
 *
 */
public abstract class Function<I,O> {

	public abstract O call(I x);
	public List<O> map(List<I> x){
		LinkedList<O> output = new LinkedList<O>();
		for(I elem : x){
			output.add(call(elem));
		}
		return output;
	}
	public Function<I,O> after(final Function<I,I> f){
		return (new Function<I,O>(){
			public O call(I x){
				return call(f.call(x));
			}
		});
	}
}


