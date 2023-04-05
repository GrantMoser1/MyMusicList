package moser_grant.myMusicList.caseStudy.model;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.persistence.PostLoad;
import jakarta.validation.Constraint;
import moser_grant.myMusicList.caseStudy.service.FieldMatchValidator;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = FieldMatchValidator.class)
@Documented
public @interface FieldMatch
{
   String message() default "{constraints.field-match}";
   Class<?>[] groups() default {};
   Class<? extends PostLoad>[] payload() default {};
   String first();
   String second();

   @Target({TYPE, ANNOTATION_TYPE})
   @Retention(RUNTIME)
   @Documented
   @interface List
   {
       FieldMatch[] value();
   }
}