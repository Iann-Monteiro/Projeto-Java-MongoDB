package com.ianndev.workshop.service;

import com.ianndev.workshop.domain.Post;
import com.ianndev.workshop.domain.User;
import com.ianndev.workshop.dto.UserDTO;
import com.ianndev.workshop.repository.PostRepository;
import com.ianndev.workshop.repository.UserRepository;
import com.ianndev.workshop.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class PostService implements Serializable {

    public static final long serialVersionUID = 1L;

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<Post> findByTitle(String text){
        return repo.searchTitle(text);
    }
}
