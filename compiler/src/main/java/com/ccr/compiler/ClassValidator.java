package com.ccr.compiler;

import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

import static javax.lang.model.element.Modifier.ABSTRACT;
import static javax.lang.model.element.Modifier.PRIVATE;
import static javax.lang.model.element.Modifier.PUBLIC;

/**
 * @Created on 2018/9/1.
 * @autthor Acheng
 * @Email 345887272@qq.com
 * @Description
 */
final class ClassValidator {
    static boolean isPublic(Element annotatedClass) {
        return annotatedClass.getModifiers().contains(PUBLIC);
    }

    static boolean isPrivate(Element annotatedClass) {
        return annotatedClass.getModifiers().contains(PRIVATE);
    }

    static boolean isAbstract(Element annotatedClass) {
        return annotatedClass.getModifiers().contains(ABSTRACT);
    }

    static String getClassName(TypeElement type, String packageName) {
        int packageLen = packageName.length() + 1;
        return type.getQualifiedName().toString().substring(packageLen)
                .replace('.', '$');
    }
}
