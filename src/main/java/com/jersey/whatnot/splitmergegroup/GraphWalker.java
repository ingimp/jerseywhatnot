package com.jersey.whatnot.splitmergegroup;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

import java.util.List;

import static com.google.common.collect.FluentIterable.from;
import static com.google.common.collect.Iterables.concat;

public class GraphWalker {
    private PlasticineEntity plasticine;
    private List<PlasticineEntity> visited = Lists.newArrayList();

    public GraphWalker(PlasticineEntity plasticine) {
        this.plasticine = plasticine;
    }

    public List<PlasticineEntity> walkGraph() {
        return from(walk(plasticine)).filter(new Predicate<PlasticineEntity>() {
            @Override
            public boolean apply(PlasticineEntity input) {
                return !input.isMiddleStatus();
            }
        }).toList();
    }

    private List<PlasticineEntity> walk(PlasticineEntity plasticine) {
        if (visited.contains(plasticine)) {
            return visited;
        }
        visited.add(plasticine);
        Iterable<PlasticineEntity> adjacent = concat(plasticine.getChildren(), plasticine.getParents());
        for (PlasticineEntity adjecentPlasticine : adjacent) {
            walk(adjecentPlasticine);
        }

        return visited;
    }
}
