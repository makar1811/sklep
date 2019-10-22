package pl.training.cloud.shop.shop.controler;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

class UriBuilder {

    URI requestUriWithId(long id) {
        return ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }

}
