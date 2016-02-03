package com.gudong.gankio.ui.activity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.gudong.gankio.R;
import com.gudong.gankio.presenter.ProvisionPresenter;
import com.gudong.gankio.ui.view.IBaseView;

import butterknife.Bind;

/**
 * 服务条款
 */
public class ProvisionActivity extends BaseActivity<ProvisionPresenter> implements IBaseView {

    @Bind(R.id.wb)WebView wb;
    String html = "<p><strong><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">1、服务条款的确认和接纳</span></strong></p><p><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(89, 89, 89);\">本网站及APP的各项内容和服务的所有权归本公司拥有。用户在接受本服务之前，请务必仔细阅读本条款。用户使用服务，或通过完成注册程序，表示用户接受所有服务条款。</span></span></p><p><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\"><br/></span></p><p><strong><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">2、用户同意：</span></strong></p><p><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(89, 89, 89);\">(1) 提供及时、详尽及准确的个人资料。</span></span></p><p><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(89, 89, 89);\">&nbsp;&nbsp;&nbsp;&nbsp;(2) 不断更新注册资料、符合及时、详尽、准确的要求。如果用户提供的资料不准确，本网站有结束服务的权利。本网站及APP将不公开用户的 &nbsp; &nbsp; &nbsp; &nbsp; 姓名、地址、电子邮箱、帐号和电话号码等信息（请阅隐私保护条款）。用户在本网站和APP的任何行为必须遵循：</span></p><p><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(89, 89, 89);\">&nbsp;&nbsp;&nbsp;&nbsp;(1) 传输资料时必须符合中国有关法规。</span></p><p><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(89, 89, 89);\">&nbsp;&nbsp;&nbsp;&nbsp;(2) 使用信息服务不作非法用途和不道德行为。</span></p><p><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(89, 89, 89);\">&nbsp;&nbsp;&nbsp;&nbsp;(3) 不干扰或混乱网络服务。</span></p><p><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(89, 89, 89);\">&nbsp;&nbsp;&nbsp;&nbsp;(4) 遵守所有使用服务的网络协议、规定、程序和惯例。用户的行为准则是以因特网法规，政策、程序和惯例为根据的。</span></p><p><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\"><br/></span></p><p><strong><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">3、服务条款的修改</span></strong></p><p><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(89, 89, 89);\">本网站及APP有权在必要时修改条款，将会在页面公布。如果不接受所改动的内容，用户可以主动取消自己的会员资格。如果您不取消自己的会员资格，则视为接受服务条款的变动。</span></span></p><p><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\"><br/></span></p><p><strong><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">4、用户的帐号、密码和安全性</span></strong></p><p><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(89, 89, 89);\">一旦成功注册成为会员，您将有一个密码和用户名。用户将对用户名和密码的安全负全部责任。另外，每个用户都要对以其用户名进行的所有活动和事件负全责。您可以随时改变您的密码。用户若发现任何非法使用用户帐号或存在安全漏洞的情况，请立即通告本公司。</span></span></p><p><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\"><br/></span></p><p><strong><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">5、拒绝提供担保</span></strong></p><p><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(89, 89, 89);\">用户明确同意使用本公司服务，由用户个人承担风险。</span></span></p><p><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(89, 89, 89);\">本网站及APP不担保服务一定满足用户的要求，也不担保服务不会中断，对服务的及时性、安全性、出错发生都不作担保。用户理解并接受：任何通过服务取得的信息资料的可靠性有用性取决于用户自己的判断，用户自己承担所有风险和责任。</span></p><p><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\"><br/></span></p><p><strong><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">6、有限责任</span></strong></p><p><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(89, 89, 89);\">本网站及APP对任何由于使用服务引发的直接、间接、偶然及继起的损害不负责任。这些损害可能来自（包括但不限于）：不正当使用服务，或传送的信息不符合规定等。</span></span></p><p><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\"><br/></span></p><p><strong><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">7、对用户信息的存储和限制</span></strong></p><p><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(89, 89, 89);\">本网站及APP不对用户发布信息的删除或储存失败负责，本公司有判定用户的行为是否符合服务条款的要求和精神的保留权利。如果用户违背了服务条款的规定，有中断对其提供服务的权利。</span></span></p><p><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\"><br/></span></p><p><strong><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">8、结束服务</span></strong></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; font-size: 12px; color: rgb(89, 89, 89);\">本网站及APP可随时根据实际情况中断一项或多项服务，不需对任何个人或第三方负责或知会。同时用户若反对任何服务条款的建议或对后来的条款修改有异议，或对服务不满，用户可以行使如下权利：</span></span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(89, 89, 89);\">&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(89, 89, 89); font-size: 12px;\">(1) 不再使用本公司的服务。</span></span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(89, 89, 89);\">&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(89, 89, 89); font-size: 12px;\">(2) 通知本公司停止对该用户的服务。</span></span></p><p><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\"><br/></span></p><p><strong><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">9、信息内容的所有权</span></strong></p><p><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(89, 89, 89);\">本公司的信息内容包括：文字、软件、声音、相片、录象、图表；以及其它信息，所有这些内容受版权、商标、标签和其它财产所有权法律的保护。用户只能在授权下才能使用这些内容，而不能擅自复制、再造这些内容、或创造与内容有关的派生产品。</span></span></p><p><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\"><br/></span></p><p><strong><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">10、隐私保护条款</span></strong></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; font-size: 12px; color: rgb(89, 89, 89);\">本网站及APP将严格保守用户的个人隐私，承诺未经过您的同意不将您的个人信息任意披露。但在以下情形下，我们将无法再提供您前述保证而披露您的相关信息。这些情形包括但不限于：</span></span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(89, 89, 89);\">&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(89, 89, 89); font-size: 12px;\">(1)为了您的交易顺利完成，我们不得不把您的某些信息，如您的姓名、联系电话、e-mail等提供给相关如物流服务方，以便于他们及时与您取得联系，提供服务。</span></span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(89, 89, 89);\">&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(89, 89, 89); font-size: 12px;\">(2)当您在本网站的行为违反的服务条款，或可能损害他人权益或导致他人遭受损害，只要我们相信披露您的个人资料是为了辨识、联络或采取法律行动所必要的行动时。</span></span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(89, 89, 89);\">&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(89, 89, 89); font-size: 12px;\">(3)法律法规所规定的必须披露或公开的个人信息。</span></span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(89, 89, 89);\">&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(89, 89, 89); font-size: 12px;\">(4)当司法机关或其它有权机关依法执行公务，要求提供特定个人资料时，我们必须给予必要的配合。</span></span></p><p><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\"><br/></span></p><p><strong><span style=\"font-size: 12px; font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">11、适用法律</span></strong></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; font-size: 12px; color: rgb(89, 89, 89);\">上述条款将适用中华人民共和国的法律，所有的争端将诉诸于本网所在地的人民法院。</span></span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(89, 89, 89);\">&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(89, 89, 89); font-size: 12px;\">如发生服务条款与中华人民共和国法律相抵触时，则这些条款将完全按法律规定重新解释，而其它条款则依旧保持约束力。楼下的店”是由深圳市紫瑞天成网络技术有限公司开发的一款社区购物APP。</span></span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(89, 89, 89);\">&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(89, 89, 89); font-size: 12px;\">我们的目标是让中国成千上万社区的千万家实体店面上线，与小区业主和顾客实现零成本的实时沟通，提升中国人社区生活购物的便利性。</span></span></p><p><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(89, 89, 89);\">&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; color: rgb(89, 89, 89); font-size: 12px;\">为了生活购物更便利，我们出发了！</span></span><br/></p>";


    @Override
    protected void initKProgressHUD() {

    }

    @Override
    protected void initPresenter() {
        mPresenter = new ProvisionPresenter(this,this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_provision;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getResources().getString(R.string.action_title_provision), true);
        //加载网页数据
        wb.loadDataWithBaseURL(null, html, "text/html", "utf-8", null);
        WebSettings webSettings= wb.getSettings();
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
    }

    @Override
    public void showLoading(boolean isShow) {

    }

    @Override
    public void doSomthing(String msg, int code) {

    }
}
