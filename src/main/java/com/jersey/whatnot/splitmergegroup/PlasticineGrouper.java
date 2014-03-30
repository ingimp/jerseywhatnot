package com.jersey.whatnot.splitmergegroup;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;

import java.util.List;

import static com.google.common.collect.FluentIterable.from;
import static com.google.common.collect.Lists.newArrayList;

public class PlasticineGrouper {
    public List<List<PlasticineEntity>> groupPlastines(List<PlasticineEntity> plasticines) {
        final List<PlasticineEntity> processedPlasticines = Lists.newArrayList();

        FluentIterable<List<PlasticineEntity>> groups = from(plasticines).transform(new Function<PlasticineEntity, List<PlasticineEntity>>() {
            @Override
            public List<PlasticineEntity> apply(PlasticineEntity plasticine) {
                if (processedPlasticines.contains(plasticine)) {
                    return null;
                }

                if (plasticine.isSingle()) {
                    processedPlasticines.add(plasticine);
                    return newArrayList(plasticine);
                } else {
                    List<PlasticineEntity> walkResult = new GraphWalker(plasticine).walkGraph();
                    processedPlasticines.addAll(walkResult);
                    return walkResult;
                }
            }
        });

        return groups
                .filter(removeNull())
                .transform(removeMiddleStatus())
                .toList();
    }

    private Function<List<PlasticineEntity>, List<PlasticineEntity>> removeMiddleStatus() {
        return new Function<List<PlasticineEntity>, List<PlasticineEntity>>() {
            @Override
            public List<PlasticineEntity> apply(List<PlasticineEntity> group) {
                return from(group).filter(new Predicate<PlasticineEntity>() {
                    @Override
                    public boolean apply(PlasticineEntity plasticine) {
                        return !plasticine.isMiddleStatus();
                    }
                }).toList();
            }
        };
    }

    private Predicate<List<PlasticineEntity>> removeNull() {
        return new Predicate<List<PlasticineEntity>>() {
            @Override
            public boolean apply(List<PlasticineEntity> group) {
                return group != null;
            }
        };
    }
}
