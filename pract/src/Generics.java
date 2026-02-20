import java.util.ArrayList;
import java.util.List;

public interface Generics<REQ, RES> {
    // <? extends Integer> means actual type can be Integer and their sub-types
    // so, inserting not guarantee you that which one is gonna inserted, type safety will break
    // in case of reading, Integer a = list.get(0); will always work as Integer is the parent class (Polymorphism)

    // <? super Integer> means actual type can be the Integer, Number, Object
    // so, inserting would be allowed, as we know that the allowed type is the Integer
    // reading is not allowed, the big confusion why??
    // <? super Integer> list = Arrays.asList(2, 2.5, 9L); // this is allowed
    // list.add(7.5) // this is not allowed, now due to the initialization can have any values, and hence retrieval won't give you the type safety guarantee
    // Always remember, `?` wildcard always being used as the Type Argument not the Type Parameter
    // Like here in Generics<REQ, RES> --> REQ and RES are the type parameter
    // List<?> list = new ArrayList<>();
    // So once you use the component to define the type parameter, then you can use wildcard to say I don't care of any specific type but allow everything, or everything with some constraints (using super / extends).
    // ========
    // (1) ? extends T -> T == Number and subtypes of Number -- Integer / Long etc
    //(2) ? super T -> T == Number and supers of Numbers == Object
    // extends -> super => You’re moving items from a smaller box (subtype) to a larger box (supertype)

    RES getResult(REQ req);
}
