package com.utrecht.workingtalentdemo.controller;


import com.utrecht.workingtalentdemo.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Service("tagService")
public class TagService {
    @Autowired
    private TagRepository tr;


}
