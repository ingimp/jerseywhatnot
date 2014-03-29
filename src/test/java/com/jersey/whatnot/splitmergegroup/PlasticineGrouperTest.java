package com.jersey.whatnot.splitmergegroup;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import org.junit.Test;

import java.util.List;

public class PlasticineGrouperTest {
    @Test
    public void should_group_single_plasticine() throws Exception {
        //把橡皮泥读出来
        List<PlasticineEntity> plasticines = new PlasticineReader().readPlasticines();

        //分组
        List<List<PlasticineEntity>> plasticineGroups = new PlasticineGrouper().groupPlastines(plasticines);

        //id为1的橡皮泥自己是一组
        FluentIterable.from(plasticineGroups).anyMatch(new Predicate<List<PlasticineEntity>>() {
            @Override
            public boolean apply(List<PlasticineEntity> group) {
                return group.size() == 1 && group.get(0).getId() == 1;
            }
        });
    }
}
