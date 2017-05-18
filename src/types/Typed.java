package types;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation indicates that the instances of this class have a "type" which defines some of their properties and may be defined in different ways with respect to this class.
 * This annotation may be used with classes that implement Nameable, and it must be fulfilled that the method getType returns the same string iff the instances are of the same type as "type" is defined for that class.
 * @see types.Typed.Typification
 * @author Javier
 *
 */
@Retention(RetentionPolicy.SOURCE)
@Documented
@Target(ElementType.TYPE)
@Inherited
public @interface Typed {
	
	/**
	 * Indicates that this field of a @Typed class determines the type of an instance.
	 * @see types.Typed
	 * @author Javier
	 *
	 */
	@Retention(RetentionPolicy.SOURCE)
	@Documented
	@Target(ElementType.FIELD)
	@Inherited
	public static @interface Type {
	}
	
	/**
	 * Enumeration of the relationships a @Typed class may have with the types of its instances.
	 * @see types.Typed
	 * @see types.Typed.Typification.CLASS
	 * @see types.Typed.Typification.INSTANCE
	 * @see types.Typed.Typification.FIELD
	 * @see types.Typed.Typification.GLOBAL
	 * @author Javier
	 *
	 */
	public static enum Typification {
		/**
		 * One class, one type.
		 * 
		 * The type of the instances of this class is determined by which class was instanced.
		 * These are typically implemented by extending this class and declaring new properties in every class.
		 * The type is checked by checking the class.
		 */
		CLASS,
		/**
		 * One instance, one type.
		 * 
		 * Each instance of this class defines a type in itself and its properties.
		 * Instances of other classes refer to the instances of this class to define what type of thing they refer to.
		 * The type is checked by checking the reference.
		 */
		INSTANCE,
		/**
		 * Multiple instances, one type.
		 * 
		 * The type or properties of each instance of this class is stored in its fields.
		 * Different instances of the same class may share a type by defining the same type-determining properties or characteristics within, or be of different types.
		 * The type is checked by checking the contents of a field.
		 */
		FIELD,
		/**
		 * All instances, one type.
		 * 
		 * All instances of this class are considered to be of a single type.
		 * The type is determined by the class.
		 * The type doesn't need to be checked.
		 */
		GLOBAL
	}
	/**
	 * Typification a @Typed class uses.
	 * @see types.Typed
	 */
	Typification typification();
	
}
