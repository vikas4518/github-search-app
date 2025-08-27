package com.vikas.github.proj;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repos")
@CrossOrigin(origins = "*") 
public class RepoController {

    private final GithubService githubService;

    public RepoController(GithubService githubService) {
        this.githubService = githubService;
    }

    @GetMapping("/search")
    public List<RepositoryData> searchRepos(@RequestParam String keyword) {
        return githubService.searchAndSaveRepos(keyword);
    }

    @GetMapping
    public List<RepositoryData> getAllRepos() {
        return githubService.getAllRepos();
    }
}

