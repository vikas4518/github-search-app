package com.vikas.github.proj;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GithubService {

    private final RepositoryDataRepo repo;

    public GithubService(RepositoryDataRepo repo) {
        this.repo = repo;
    }

    public List<RepositoryData> searchAndSaveRepos(String keyword) {
        String url = "https://api.github.com/search/repositories?q=" + keyword;

        RestTemplate restTemplate = new RestTemplate();
        var response = restTemplate.getForObject(url, GithubResponse.class);

        List<RepositoryData> repos = response.getItems().stream().map(item -> {
            RepositoryData data = new RepositoryData();
            data.setName(item.getName());
            data.setUrl(item.getHtmlUrl());
            data.setDescription(item.getDescription());
            data.setStars(item.getStargazersCount());
            return data;
        }).collect(Collectors.toList());

        return repo.saveAll(repos);
    }

    public List<RepositoryData> getAllRepos() {
        return repo.findAll();
    }
}

