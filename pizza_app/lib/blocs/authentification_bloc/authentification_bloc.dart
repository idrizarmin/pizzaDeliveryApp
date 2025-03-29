import 'dart:async';

import 'package:bloc/bloc.dart';
import 'package:equatable/equatable.dart';
import 'package:user_repository/user_repository.dart';

part 'authentification_event.dart';
part 'authentification_state.dart';

class AuthentificationBloc
    extends Bloc<AuthentificationEvent, AuthentificationState> {
  final UserRespository userRespository;
  late final StreamSubscription<MyUser?> _userSubscrioption;

  AuthentificationBloc({required this.userRespository})
    : super(const AuthentificationState.unknown()) {
    _userSubscrioption = userRespository.user.listen((user) {
      add(AuthentificationUserChanged(user));
    });
    on<AuthentificationUserChanged>((event, emit) {
      if (event.user != MyUser.empty) {
        emit(AuthentificationState.authentificated(event.user!));
      } else {
        emit(const AuthentificationState.unauthentificated());
      }
    });
  }
}
