package spring.reborn.domain.reborn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.reborn.config.BaseException;
import spring.reborn.config.BaseResponse;
import spring.reborn.domain.reborn.model.PatchRebornReq;
import spring.reborn.domain.reborn.model.PostRebornReq;
import spring.reborn.domain.reborn.model.PostRebornRes;

import javax.sound.midi.Patch;

import static spring.reborn.config.BaseResponseStatus.DATABASE_ERROR;
import static spring.reborn.config.BaseResponseStatus.MODIFY_FAIL_REBORN;

@Service
public class RebornService {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final RebornDao rebornDao;
    private final RebornProvider rebornProvider;

    @Autowired
    public RebornService(RebornDao rebornDao, RebornProvider rebornProvider) {
        this.rebornDao = rebornDao;
        this.rebornProvider = rebornProvider;
    }

    @Transactional
    public PostRebornRes createReborn(PostRebornReq postRebornReq) throws BaseException {
        try {
            System.out.println("service 시작");
            int rebornIdx = rebornDao.createReborn(postRebornReq);
            System.out.println("dao 끝");
            return new PostRebornRes(rebornIdx);
        } catch (Exception e) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

    @Transactional
    public String patchReborn(PatchRebornReq patchRebornReq) throws BaseException {
        try {
            int v = rebornDao.patchReborn(patchRebornReq);
            if (v == 0)
                throw new BaseException(MODIFY_FAIL_REBORN);
            String result = "상품 수정 성공!";
            return result;
        } catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }
}
