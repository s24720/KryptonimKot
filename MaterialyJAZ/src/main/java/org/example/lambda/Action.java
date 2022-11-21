package org.example.lambda;

import java.util.function.Predicate;

public class Action {
    public Action(iProvide provide) {
        provide.print();
    }

    public void SelectByGender(Predicate<SearchParameters> parametersPredicate, SearchParameters searchParameters) {
        System.out.println(parametersPredicate.test(searchParameters));
    }
}
