package com.jersey.whatnot.splitmergegroup;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
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
        System.out.println("start waling. root: " + plasticine);
        List<PlasticineEntity> result = walk(plasticine);
        System.out.println("finished waling. root: " + plasticine);

        return result;
    }

    private List<PlasticineEntity> walk(PlasticineEntity plasticine) {
        if (visited.contains(plasticine)) {
            System.out.println("already walked: " + plasticine + ". return.");
            return visited;
        }
        System.out.println("walking: " + plasticine);
        visited.add(plasticine);

        Iterable<PlasticineEntity> adjacent = concat(plasticine.getChildren(), plasticine.getParents());
        System.out.println("adjacent of: " + plasticine + " are: " + adjacent);

        for (PlasticineEntity adjecentPlasticine : adjacent) {
            walk(adjecentPlasticine);
        }
        System.out.println("finished walking adjacent of: " + plasticine + ". return.");

        return visited;
    }
}
