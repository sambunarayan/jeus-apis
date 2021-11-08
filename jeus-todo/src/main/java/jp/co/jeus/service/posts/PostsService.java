package jp.co.jeus.service.posts;

import jp.co.jeus.domain.posts.Posts;
import jp.co.jeus.domain.posts.PostsRepository;
import jp.co.jeus.web.dto.PostListResponseDto;
import jp.co.jeus.web.dto.PostsResponseDto;
import jp.co.jeus.web.dto.PostsSaveRequestDto;
import jp.co.jeus.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No result record. id = " + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    @Transactional
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No result record. id = " + id));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No data. id=" + id));
        postsRepository.delete(posts);
    }
}
