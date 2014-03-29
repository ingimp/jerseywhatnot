package com.jersey.whatnot.splitmergegroup;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;

import java.util.List;

import static com.google.common.collect.FluentIterable.from;

public class PlasticineGrouper {
    public List<List<PlasticineEntity>> groupPlastines(List<PlasticineEntity> plasticines) {
        FluentIterable<List<PlasticineEntity>> groups = from(plasticines).transform(new Function<PlasticineEntity, List<PlasticineEntity>>() {
            @Override
            public List<PlasticineEntity> apply(PlasticineEntity plasticine) {
                if (plasticine.isSingle()) {
                    return Lists.newArrayList(plasticine);
                }
                return null;
            }
        });

        return groups.filter(isGroupFilled()).toList();
    }

    private Predicate<List<PlasticineEntity>> isGroupFilled() {
        return new Predicate<List<PlasticineEntity>>() {
            @Override
            public boolean apply(List<PlasticineEntity> group) {
                return group != null;
            }
        };
    }
}
