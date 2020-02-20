package org.belldj.mntest.user.web;

import org.belldj.mntest.user.domain.UserApi;
import org.belldj.mntest.web.Transport;
import org.immutables.value.Value;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;

@Transport
@Value.Immutable
@JsonSerialize(as = UserAddCommandT.class)
@JsonDeserialize(as = UserAddCommandT.class)
@Schema(name = "AddUserCommand", description = "The user to be added")
public interface UserAddCommandSpec extends UserApi.UserAddCommand {
}