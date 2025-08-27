package com.vikas.github.proj;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class GithubResponse {
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public static class Item {
        private String name;

        @JsonProperty("html_url")
        private String htmlUrl;

        private String description;

        @JsonProperty("stargazers_count")
        private int stargazersCount;

        // getters and setters
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getHtmlUrl() { return htmlUrl; }
        public void setHtmlUrl(String htmlUrl) { this.htmlUrl = htmlUrl; }

        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }

        public int getStargazersCount() { return stargazersCount; }
        public void setStargazersCount(int stargazersCount) { this.stargazersCount = stargazersCount; }
    }
}
