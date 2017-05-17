package types;

/**
 * This annotation indicates that the instances of this class have a type which defines some of their properties.
 * @author Javier
 *
 */
public @interface Typed {
	
	/**
	 * Indicates this field determines the type of an instance.
	 * @author Javier
	 *
	 */
	public @interface TypeField {
		
	}
	
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
		 * Many instances, one type.
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
	
	Typification typification();
	
}
