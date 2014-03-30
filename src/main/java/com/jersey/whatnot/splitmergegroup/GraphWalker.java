package com.jersey.whatnot.splitmergegroup;

import com.google.common.collect.Lists;

import java.util.List;

import static com.google.common.collect.Iterables.concat;

public class GraphWalker {
    private PlasticineEntity plasticine;
    private List<PlasticineEntity> visited;

    public GraphWalker(PlasticineEntity plasticine) {
        this.plasticine = plasticine;
    }

    public List<PlasticineEntity> walkGraph() {
        visited = Lists.newArrayList();
        System.out.println("start waling. root: " + plasticine);
        walk(plasticine);
        System.out.println("finished waling. root: " + plasticine);

        return visited;
    }

    private void walk(PlasticineEntity plasticine) {
        if (visited.contains(plasticine)) {
            System.out.println("already walked: " + plasticine + ". return.");
            return;
        }

        System.out.println("walking: " + plasticine);
        visited.add(plasticine);

        Iterable<PlasticineEntity> adjacent = concat(plasticine.getChildren(), plasticine.getParents());
        System.out.println("adjacent of: " + plasticine + " are: " + adjacent);

        for (PlasticineEntity adjecentPlasticine : adjacent) {
            walk(adjecentPlasticine);
        }
        System.out.println("finished walking adjacent of: " + plasticine + ". return.");
    }
}
