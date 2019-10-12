package com.demo.parse;

import com.demo.annotation.AnnotationTest;
import com.google.auto.service.AutoService;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * Created by tuoanlan on 2019/9/27.
 */






//指名需要处理的注解类
@SupportedAnnotationTypes("com/demo/annotation/AnnotationTest.java")

//指定编译的版本。这种通过注解指定编译版本和类型的方式是从Java 1.7才有的。 对于之前的版本都是通过重写AbstractProcessor中的方法来指定的。
@SupportedSourceVersion(SourceVersion.RELEASE_7)

@AutoService(Processor.class)
public class Processor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        //遍历元素类型
        for (TypeElement typeElement:annotations){
            for (Element element : roundEnv.getElementsAnnotatedWith(typeElement)) {
                AnnotationTest annotation = element.getAnnotation(AnnotationTest.class);
                String value = annotation.value();
                System.out.println("注解的值为"+value);
            }
        };
        return false;
    }
}
